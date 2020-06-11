package com.company.task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 4};
        Massiv massiv = new Massiv(arr);
        System.out.println("Заполненный массив:");
        massiv.print();
        System.out.println("Добавили в начало элемент:");
        massiv.add(0, 5);
        massiv.print();
        System.out.println("Добавили в конец элемент:");
        massiv.add(6);
        massiv.print();
        System.out.println("Удаление пятого элемента в массиве:");
        massiv.remove(5);
        massiv.print();
        System.out.println("Максимальное значение в массиве: "+massiv.max());
        System.out.println("Минимавльное значение в массиве: "+massiv.min());
        System.out.println("Сортировка массива по возрастанию "+Arrays.toString(massiv.sortAcs()));
        System.out.println("Сортировка массива по убыванию "+Arrays.toString(massiv.sortDesc()));
        massiv.equalFilling(0);
        System.out.println("Заполнение всего массива одним элементом:");
        massiv.print();
    }
}
