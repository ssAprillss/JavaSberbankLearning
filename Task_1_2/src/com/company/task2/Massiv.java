package com.company.task2;

public class Massiv {

    int arr[];

    public Massiv(int a[]) {
        arr = a;
    }

    //Получить элемент по индексу
    public int get(int index) {
        return arr[index];
    }

    //Установить значение указанного элемента
    public void set(int index, int value) {
        arr[index] = value;
    }

    //Получить рамер массива
    public int size() {
        return arr.length;
    }

    //Добавить элемент в конкретную позицию
    public void add(int index, int val) {
        if (index <= arr.length + 1) {
            int[] tempArr = new int[arr.length + 1];
            for (int i = 0; i < index; i++) {
                tempArr[i] = arr[i];
            }
            tempArr[index] = val;
            for (int i = index + 1; i < arr.length + 1; i++) {
                tempArr[i] = arr[i - 1];
            }
            arr = tempArr;
        }
    }

    //Добавить элемент в конец массива
    public void add(int val) {
        int[] tempArr = new int[arr.length + 1];
        int a = 0;
        for (int i = 0; i < arr.length; i++) {
            tempArr[i] = arr[i];
        }
        tempArr[tempArr.length - 1] = val;
        arr = tempArr;
    }

    //Удалить элемент по индексу
    public void remove(int index) {
        int[] tempArr = new int[arr.length - 1];
        for (int i = 0; i < index; i++) {
            tempArr[i] = arr[i];
        }
        for (int i = index; i < arr.length - 1; i++) {
            tempArr[i] = arr[i + 1];
        }
        arr = tempArr;
    }

    //Получить максимальное значение в массиве
    public int max() {
        int max = arr[0];
        for (int i : arr) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    //Получить минимальное значение в массиве
    public int min() {
        int min = arr[0];
        for (int i : arr) {
            if (i < min) {
                min = i;
            }
        }
        return min;
    }

    //Вывести массив на экран
    public void print() {
        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                b.append(arr[i]);
                b.append(']');
            } else {
                b.append(arr[i]);
                b.append(',');
            }
        }
        System.out.println(b.toString());
    }

    //Заполнить весь массив одинаковыми значениями
    public void equalFilling(int val) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = val;
        }
    }

    //Сортировка по возрастанию
    public int[] sortAcs() {
        int[] tempArr = arr;
        for (int i = 0; i < tempArr.length - 1; i++) {
            for (int j = tempArr.length - 1; j > i; j--) {
                if (tempArr[j - 1] > tempArr[j]) {
                    int tmp = tempArr[j - 1];
                    tempArr[j - 1] = tempArr[j];
                    tempArr[j] = tmp;
                }
            }
        }
        return tempArr;
    }

    //Сортировка по убыванию
    public int[] sortDesc() {
        int[] tempArr = arr;
        for (int i = 0; i < tempArr.length - 1; i++) {
            for (int j = tempArr.length - 1; j > i; j--) {
                if (tempArr[j - 1] < tempArr[j]) {
                    int tmp = tempArr[j - 1];
                    tempArr[j - 1] = tempArr[j];
                    tempArr[j] = tmp;
                }
            }
        }
        return tempArr;
    }
}

