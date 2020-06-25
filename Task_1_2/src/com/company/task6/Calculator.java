package com.company.task6;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator implements Sumable,Negateble,Multible,Deviateble{

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
