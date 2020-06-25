package com.company.task8;
import com.company.task7.Printable;

public class PrimeNumbers implements Printable {

    private int maxNumber;
    private int[] primeNumbers;
    private boolean[] mask;

    public PrimeNumbers(int maxNumber) {
        this.maxNumber = maxNumber;
        if(maxNumber >= 2){
        mask = getMask(maxNumber);
        primeNumbers = getPrimalNumbers(mask);
        };
    }

    public int getMaxNumber() {
        return maxNumber;
    }

    public int[] getPrimeNumbers() {
        return primeNumbers;
    }

    public void setMaxNumber(int maxNumber) {
        this.maxNumber = maxNumber;
        if(maxNumber >= 2){
            mask = getMask(maxNumber);
            primeNumbers = getPrimalNumbers(mask);
        };
    }

    private boolean[] getMask(int maxNumber) {
        int z = maxNumber + 1;
        boolean[] mask = new boolean[z];
        // Заполняем массив true
        for (int i = 0; i < z; i++) {
            mask[i] = true;
        }
        mask[0] = mask[1] = false; //Удаляем числа, которые точно не простые 0 и 1
        // Алгоритм Решето Эратосфена
        for (int i = 2; i < Math.sqrt(z) + 1; i++) {
            // Вычеркиваем числа кратные данному числу
            if (mask[i]) {
                for (int j = 2 * i; j < z; j += i) {
                    mask[j] = false;
                }
            }
        }
        return mask;
    }

    private int[] getPrimalNumbers(boolean[] mask) {
        //Получение массива по маске
        int[] primeNumbers = new int[getSize()];
        for (int i = 0, j = 0; i < maxNumber + 1; i++) {
            if (mask[i])
                primeNumbers[j++] = i;
        }
        return primeNumbers;
    }

    public int getSize() {
        int count = 0;
        for (int i = 0; i < maxNumber + 1; i++) {
            if (mask[i])
                count++;
        }
        return count;
    }

    @Override
    public void print() {
        print(20, 5);
    }

    public void print(int maxSimbols, int maxRows) {
        if(maxNumber >=2){
        int simbolsBufferLength = 0;
        int rowsBufferLength = 0;
        for (int a : primeNumbers) {
            System.out.print(a + " ");
            simbolsBufferLength += String.valueOf(a).length() + 1;
            if (simbolsBufferLength >= maxSimbols) {
                // Переход на новую строку
                System.out.println();
                simbolsBufferLength = 0;
                rowsBufferLength++;
            }
            if (rowsBufferLength >= maxRows) {
                System.out.println("--------Новая cтраница--------");
                rowsBufferLength = 0;
            }
        }
        System.out.println("\n--------Конец--------");
        }
        else {
            System.out.println("Невозможно создать массив");
        }
    }
}