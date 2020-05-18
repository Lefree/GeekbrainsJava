package ru.geekbrains.java.practice.exceptions;

public class IllegalMatrixElement extends Exception {
    public IllegalMatrixElement(String message) {
        super(message);
    }

    public IllegalMatrixElement(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalMatrixElement(Throwable cause) {
        super(cause);
    }
}
