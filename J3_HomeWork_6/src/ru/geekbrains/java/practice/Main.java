package ru.geekbrains.java.practice;

import java.util.Arrays;

public class Main {
    private static int CONDITION_NUMBER_1 = 4;
    private static int CONDITION_NUMBER_2 = 1;
    public static void main(String[] args) {
        int [] arr = new int[] {1, 1, 1, 4, 4, 1, 4, 4};
        System.out.println(checkArray(arr));
    }

    public static int[] getFromArray(int[] arr) throws RuntimeException{
        int lastIndex = -1;
        int[] newArr;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == CONDITION_NUMBER_1)
                lastIndex = i;
        }
        if (lastIndex == -1 )
            throw new RuntimeException("Condition number: " + CONDITION_NUMBER_1 + " not found in array");
        else {
            newArr = Arrays.copyOfRange(arr, lastIndex + 1, arr.length);
        }
        return newArr;
    }

    public static boolean checkArray(int[] arr) {
        boolean has_one = false;
        boolean has_four = false;

        for (int i = 0; i < arr.length; i++ ) {
            if (arr[i] == CONDITION_NUMBER_1)
                has_four = true;
            else if (arr[i] == CONDITION_NUMBER_2)
                has_one = true;
            else
                return false;
        }
        return has_four & has_one;
    }
}