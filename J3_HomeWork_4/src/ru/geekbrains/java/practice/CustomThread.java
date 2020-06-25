package ru.geekbrains.java.practice;

public class CustomThread implements Runnable{
    private char symbol;
    CustomThread(char s) {
        symbol = s;
    }

    @Override
    public void run() {
        Main.print(symbol);
    }
}
