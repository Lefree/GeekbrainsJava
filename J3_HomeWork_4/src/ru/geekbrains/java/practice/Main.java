package ru.geekbrains.java.practice;

import java.lang.String;
import java.util.Arrays;

public class Main{
    private static Object monitor = new Object();
    private static final int PRINT_TIMES = 5;
    private static char currentSymbol = 'A';
    private static char[] symbolsForPrint = {'A', 'B', 'C'};

    public static void main(String[] args) {

        Thread t1 = new Thread(new CustomThread(symbolsForPrint[0]));
        Thread t2 = new Thread(new CustomThread(symbolsForPrint[1]));
        Thread t3 = new Thread(new CustomThread(symbolsForPrint[2]));
        t1.start();
        t2.start();
        t3.start();
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void print(char s) {
        synchronized (monitor) {
            try {
                int nextSymbolIndex = Arrays.binarySearch(symbolsForPrint, s) + 1;
                nextSymbolIndex = nextSymbolIndex >= symbolsForPrint.length ? 0 : nextSymbolIndex;
                for (int i = 0; i < PRINT_TIMES; i++) {
                    while (currentSymbol != s) {
                        monitor.wait();
                    }
                    System.out.print(s);
                    currentSymbol = symbolsForPrint[nextSymbolIndex];
                    monitor.notifyAll();
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
