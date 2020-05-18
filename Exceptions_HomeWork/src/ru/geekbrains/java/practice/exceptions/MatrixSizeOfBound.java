package ru.geekbrains.java.practice.exceptions;

public class MatrixSizeOfBound extends Exception{

    public MatrixSizeOfBound(String message) {
        super(message);
    }

    public MatrixSizeOfBound(String message, Throwable cause) {
        super(message, cause);
    }

    public MatrixSizeOfBound(Throwable cause) {
        super(cause);
    }

}
