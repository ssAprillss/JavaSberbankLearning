package com.company.task8;

public class Main {
    public static void main(String[] args) {
        /*
         * Реализация генерации всех простых чисел в заданном диапазоне
         */
        int max = 2;
        PrimeNumbers primeNumbers = new PrimeNumbers(10000);
        primeNumbers.print(20,5);
        primeNumbers.setMaxNumber(25);
        primeNumbers.print();
        primeNumbers.print();


    }
}
