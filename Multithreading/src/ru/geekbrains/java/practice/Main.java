package ru.geekbrains.java.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    static final int size = 10000000;
    static final int threadsNumber = 2;
    static final int h = size / 2;
    static float[] arr = new float[size];

    public static void main(String[] args) {

        System.out.printf("Work without thread in %.2f seconds\n", getWorkTimeWithoutThreads());
        System.out.printf("Work with threads in %.2f seconds\n", getWorkTimeWithThreads(threadsNumber));
    }

    private static void updateArray(float[] array) {
        for (int i = 0; i < array.length; i++)
            array[i] = (float)(array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5)
                * Math.cos(0.4f + i / 2));
    }

    private static float getWorkTimeWithoutThreads() {
        Arrays.fill(arr, 0, size, 1);
        long time = System.currentTimeMillis();
        updateArray(arr);
        float deltaTime = (System.currentTimeMillis() - time) * 0.001f;
        return deltaTime;
    }

    private static float getWorkTimeWithThreads(int threadsNumber) {
        Arrays.fill(arr, 0, size, 1);
        ArrayList<float[]> arrays = new ArrayList<>();
        ArrayList<ArrayUpdateThread> threads = new ArrayList<>();
        int arraySize = size / threadsNumber;
        for (int i = 0; i < threadsNumber; i++) {
            arrays.add(new float[arraySize]);
            threads.add(new ArrayUpdateThread("Thread--0" + (i+1), arrays.get(i)));
        }
        long threadsTime = System.currentTimeMillis();
        for (int i = 0; i < threadsNumber; i++) {
            System.arraycopy(arr, 0, arrays.get(i), 0, arraySize);
        }
        
        for (int i = 0; i < threads.size(); i++)
            threads.get(i).start();
        try {
            for (int i = 0; i < threads.size(); i++) {
                threads.get(i).join();
                System.arraycopy(arrays.get(i), 0, arr, 0, arraySize);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        float threadsDeltaTime = (System.currentTimeMillis() - threadsTime) * 0.001f;
        return threadsDeltaTime;
    }
    static class ArrayUpdateThread extends Thread{
        float[] array;

        ArrayUpdateThread(String name, float[] arr) {
            super(name);
            this.array = arr;
        }

        public void run() {
            System.out.printf("%s started its work\n", getName());
            updateArray(array);
            System.out.printf("%s finished its work\n", getName());
        }
    }
}
