package com.company.task6;


public class Main {
    public static void main(String[] args)  {
        Calculator calculator = new Calculator();
        System.out.println(Deviateble.dev(6,8));
        System.out.println(Deviateble.dev(6.3,8));
        System.out.println(Multible.mul(6,8));
        System.out.println(Sumable.sum(6,8));
        System.out.println(Deviateble.dev(6,8.8));
        System.out.println(Calculator.calculate("-3-64/8+21+2*0.25"));
        System.out.println(Calculator.calculate("-42--3"));
        System.out.println(Calculator.calculate("--42--3"));
        System.out.println(Calculator.calculate("-25--4*2"));
        System.out.println(EngineeringCalculator.pow(2,5));
        System.out.println(EngineeringCalculator.Sqrt(16));
    }
}
