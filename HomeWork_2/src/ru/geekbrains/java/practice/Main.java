package ru.geekbrains.java.practice;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] firstArray = { 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 };
        int[] secondArray = new int[8];
        int[] thirdArray = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        int[] fourthArray = {22, 1, 65, 3, 42, 18, 0, 100};
        int [][] fifthArray = new int[4][4];
        int[] sixthArray = {1, 1, 1, 2, 1};
        int[] seventhArray = {1, 2, 3, 4, 5};
        int n = 3; // число позиций для свдига в массиве

        System.out.println("Task 1 original array: " + Arrays.toString(firstArray));
        changeZeroByOne(firstArray);
        System.out.println("Task 1 result array: " + Arrays.toString(firstArray));

        System.out.println("Task 2 original array: " + Arrays.toString(secondArray));
        initArrayByStep(secondArray);
        System.out.println("Task 2 result array: " + Arrays.toString(secondArray));

        System.out.println("Task 3 original array: " + Arrays.toString(thirdArray));
        multiplyByTwo(thirdArray);
        System.out.println("Task 3 result array: " + Arrays.toString(thirdArray));

        System.out.println("Task 4 original array: " + Arrays.toString(fourthArray));
        System.out.println("Max element in array: " + maxInArray(fourthArray));
        System.out.println("Min element in array: " + minInArray(fourthArray));

        System.out.println("Task 5 original matrix: ");
        printMatrix(fifthArray);
        fillMatrixDiagonales(fifthArray);
        System.out.println("Task 5 result matrix: ");
        printMatrix(fifthArray);

        System.out.println("Task 6 original array: " + Arrays.toString(sixthArray));
        System.out.println("Check balance: " + checkBalance(sixthArray));

        System.out.println("Task 7-8 original array: " + Arrays.toString(seventhArray));
        shiftInArray(seventhArray, n);
        System.out.println("Task 7-8 result array: " + Arrays.toString(seventhArray));

    }
    /**
     * Метод вывода матриц на экран
     * @param matrix Двумерный массив
     */
    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(" " + matrix[i][j]);
            }
            System.out.println();
        }
    }
    /**
     * Метод осуществляет замену в массиве всех 0 на 1 и наоборот.
     * @param arr массив, в котором необходимо произвести замену
     */
    private static void changeZeroByOne(int[] arr) {
        for (int i = 0; i < arr.length; i ++) {
            arr[i] = arr[i] > 0 ? 0 : 1;
        }
    }
    /**
     * Написать метод, который помощью цикла заполнит его значениями
     * 1 4 7 10 13 16 19 22
     * @param arr Исходный массив для инициализации
     */
    private static void initArrayByStep(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * 3 + 1;
        }
    }

    /**
     * Написать метод, принимающий на вход массив и умножающий числа меньше 6 на 2;
     * @param arr исходный массив
     */
    private static void multiplyByTwo(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6)
                arr[i] *= 2;
        }
    }

    /**
     * Метод определяющий максимальный элемент в массиве
     * @param arr массив для поиска
     * @return int максимальный элемент в массиве
     */
    private static int maxInArray(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        return max;
    }

    /**
     * Метод определяющий минимальный элемент в массиве
     * @param arr массив для поиска
     * @return int минимальный элемент массива
     */
    private static int minInArray(int[] arr) {
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min)
                min = arr[i];
        }
        return min;
    }

    /**
     * Заполнить диагонали матрицы единицами
     * @param matrix Исходная матрица
     */
    private static void fillMatrixDiagonales(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][i] = 1;
            matrix[i][matrix.length - i - 1] = 1;
        }
    }

    /**
     * Написать метод, в который передается не пустой одномерный целочисленный массив,
     * метод должен вернуть true если в массиве есть место, в котором сумма левой
     * и правой части массива равны.
     * @param arr Исходный массив
     */
    private static boolean checkBalance(int[] arr) {
        int leftSum = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            leftSum += arr[i];
            int rightSum = 0;
            for (int j = i + 1; j < arr.length; j++) {
                rightSum += arr[j];
            }
            if (leftSum == rightSum) return true;
        }
        return false;
    }

    /**
     *Написать метод, которому на вход подаётся одномерный массив и число n
     * (может быть положительным, или отрицательным), при этом метод должен
     * циклически сместить все элементы массива на n позиций.
     * @param arr Исходный массив
     * @param n число сдвига
     */
    private static void shiftInArray(int[] arr, int n) {
        int tempVar, position=0;
        int reverseSignum = n > 0 ? -1 : 1;
            do {
                position = position + n;
                if (position < 0 || position >= arr.length)
                    position = position + reverseSignum * arr.length;
                tempVar = arr[0];
                arr[0] = arr[position];
                arr[position] = tempVar;
            } while (position + n != n);
    }
}
