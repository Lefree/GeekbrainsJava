package ru.geekbrains.java.practice;

import ru.geekbrains.java.practice.exceptions.IllegalMatrixElement;
import ru.geekbrains.java.practice.exceptions.MatrixSizeOfBound;

public class Main {
    private static final String str = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";
    private static final int matrixSize = 4;

    public static void main(String[] args) {
        String[][] matrix;
        try {
            matrix = getMatrixFromString(str, '\n', ' ');
            System.out.println("Matrix:");
            printMatrix(matrix);
            int halfMatrixSum = getStringMatrixSum(matrix) / 2;
            System.out.println("The half of matrix sum is: " + halfMatrixSum);
        } catch (MatrixSizeOfBound e) {
            System.out.println(e.getMessage());
        } catch (IllegalMatrixElement e) {
            System.out.println(e.getMessage());
        }
    }

    private static void printMatrix(Object[][] s) {
        for (int row = 0; row < s.length; row++) {
            for (int column = 0; column < s[row].length; column++)
                System.out.print(s[row][column] + " ");
            System.out.println();
        }
    }

    private static String[][] getMatrixFromString(String s,
            char rowDelimiter, char elementsDelimiter) throws MatrixSizeOfBound {

        String[][] matrix = new String[matrixSize][matrixSize];
        String[] splittedString = s.split(String.valueOf(rowDelimiter));

        if (splittedString.length > matrixSize)
            throw new MatrixSizeOfBound("The number of rows more than matrix size");

        for (int i = 0; i < splittedString.length; i++) {
            String[] tempStr = splittedString[i].split(String.valueOf(elementsDelimiter));

            if (tempStr.length > matrixSize)
                throw new MatrixSizeOfBound("The number of columns more than matrix size");
            else {
                matrix[i] = tempStr;
            }
        }
        return matrix;
    }

    private static int getStringMatrixSum(String[][] s) throws IllegalMatrixElement{
        int sum = 0;
        for (int row = 0; row < s.length; row++) {
            for (int column = 0; column < s[row].length; column++) {
                try {
                    sum += Integer.parseInt(s[row][column]);
                } catch (Exception e) {
                    throw new IllegalMatrixElement("Matrix element is not a number");
                }
            }
        }
        return sum;
    }
}


