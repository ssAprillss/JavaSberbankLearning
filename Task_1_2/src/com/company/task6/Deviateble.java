package com.company.task6;

public interface Deviateble {
     static double dev(int a, int b){
        return (double) a / b;
    }
     static double dev(float a, float b){
        return (double) a / b;
    }
     static double dev(double a, double b){
        return  a / b;
    }
}
