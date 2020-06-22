package com.company.task5;


import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main {
    public static void main(String[] args) {

        System.out.println(Calculator.dev(6,8));
        System.out.println(Calculator.dev(6.3,8));
        System.out.println(Calculator.mul(6,8));
        System.out.println(Calculator.sum(6,8));
        System.out.println(Calculator.neg(6,8.8));
        System.out.println(Calculator.calculate("-3-64/8+21+2*0.25"));
        System.out.println(Calculator.calculate("-42--3"));
        System.out.println(Calculator.calculate("--42--3"));
        System.out.println(Calculator.calculate("-25--4*2"));
    }
}
