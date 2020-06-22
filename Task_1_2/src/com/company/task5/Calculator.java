package com.company.task5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    public static int sum(int a, int b){
        return a + b;
    }
    public static float sum(float a, float b){
        return a + b;
    }
    public static double sum(double a, double b){
        return a + b;
    }

    public static int neg(int a, int b){
        return a - b;
    }
    public static float neg(float a, float b){
        return a - b;
    }
    public static double neg(double a, double b){
        return a - b;
    }

    public static int mul(int a, int b){
        return a * b;
    }
    public static float mul(float a, float b){
        return a * b;
    }
    public static double mul(double a, double b){
        return a * b;
    }

    public static double dev(int a, int b){
        return (double) a / b;
    }
    public static double dev(float a, float b){
        return (double) a / b;
    }
    public static double dev(double a, double b){
        return  a / b;
    }

    public void calcPow(int value, int power) {
        int result = value;
        for (int i = 0; i < power - 1; i++) {
            result = result * value;
        }
        System.out.println(value + " в степени " + power + " равно " + result);
    }

    public static double pow(int a, int power) {
        int result = a;
        for (int i = 0; i < power - 1; i++) {
            result = result * a;
        }
        return  result;
    }

//    Вычисление квадратного
    public static double Sqrt(int a) {
        return Math.sqrt(a);
    }


    //Парсер строки - выражения
    public static String calculate(String exp) {
        //Проверяем деление/умножение, если соответсвует регулярке - перемножаем
        StringBuilder result = new StringBuilder(exp);
        Matcher multOrDiv = Pattern.compile("\\d+\\.*\\d*+[\\*/]\\d+\\.*\\d*").matcher(exp);
        while (multOrDiv.find()) {
            int first = multOrDiv.start();
            int last = multOrDiv.end();
            result.replace(first, last, devOrMul(result.substring(first, last))); //Реплейсим то, что нашла регулярка
            exp = result.toString();
            multOrDiv = Pattern.compile("\\d+\\.*\\d*+[\\*/]\\d+\\.*\\d*").matcher(exp);
        }

//    Упрощаем работу для дальнейшего парсинга
        exp = exp.replaceAll("\\+-", "-");
        exp = exp.replaceAll("--", "+");
        exp = exp.replaceAll("-\\+", "-");
        exp = exp.replaceAll("^\\+", "");

        result = new StringBuilder(exp);

//  Теперь по регулярке ищем сложение и вычитание
        Matcher negOrSum = Pattern.compile("\\D?\\d+\\.*\\d*+[\\+-]\\d+\\.*\\d*").matcher(exp);
        while (negOrSum.find()) {
            int first = negOrSum.start();
            int last = negOrSum.end();
            result.replace(first, last, sumOrNeg(result.substring(first, last))); //Реплейсим то, что нашла регулярка
            exp = result.toString();
            negOrSum = Pattern.compile("\\D?\\d+\\.*\\d*+[\\+-]\\d+\\.*\\d*").matcher(exp);
        }
        return exp;
    }

    //Доп функция - парсит строку типа a/b или a*b и выполняет арифмитические действия
    private static String devOrMul(String exp) {
        Double a;
        String[] vars = exp.split("/");
        if (vars.length == 2) {
            a = Double.parseDouble(vars[0]) / Double.parseDouble(vars[1]);
        } else {
            vars = exp.split("\\*");
            a = Double.parseDouble(vars[0]) * Double.parseDouble(vars[1]);
        }
        return a.toString();
    }

    //Доп функция - парсит строку типа a+b или a-b и выполняет арифмитические действия
    private static String sumOrNeg(String exp) {
        Double a;
        String[] vars = exp.split("\\+");
        if (vars.length == 2) {
            a = Double.parseDouble(vars[0]) + Double.parseDouble(vars[1]);
        } else {
            vars = exp.split("-");
            if (!vars[0].equals("")) {
                a = Double.parseDouble(vars[0]) - Double.parseDouble(vars[1]);
            } else {
                a = -Double.parseDouble(vars[1]) - Double.parseDouble(vars[2]);
            }
        }
        return a.toString();
    }
}
