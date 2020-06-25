package com.company.task6;

public class EngineeringCalculator extends Calculator {

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
}
