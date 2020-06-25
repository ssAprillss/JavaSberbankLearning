package com.company.task7;

import com.company.task6.Calculator;

public class EngineeringCalculator extends Calculator {

    private static Logger logger = new Logger();

    public static double pow(int a, int power) {
        int result = a;
        logger.print("Начинаю вычисление " + a + " в степени " + power);
        for (int i = 0; i < power - 1; i++) {
            result = result * a;
        }
        logger.print("Закончил вычисление " + a + " в степени " + power);
        return  result;
    }

    //    Вычисление квадратного
    public static double Sqrt(int a) {
        return Math.sqrt(a);
    }
}
