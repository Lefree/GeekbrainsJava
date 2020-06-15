package ru.geekbrains.java.practice;

import java.util.ArrayList;

public class Array<T> {
    Object[] arr;
    public Array(T... arr) {
        this.arr = new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            this.arr[i] = arr[i];
        }
    }

    /**
     * Меняет местами 2 элемента массива по указанным порядковым номерам (1...)
     * @param firstPosition порядковый номер первого элемента
     * @param secondPosition порядковый номер второго элемента
     */
    public void changeArrayElements(int firstPosition, int secondPosition) {
        try {
            int firstIndex = firstPosition - 1;
            int secondIndex = secondPosition - 1;
            Object temp = arr[firstIndex];
            arr[firstPosition] = arr[secondIndex];
            arr[secondIndex] = temp;
        } catch (IndexOutOfBoundsException exc) {
            System.out.println("Неверно указаны порядковый номера для перестановки!");
            exc.printStackTrace();
        }
    }

    /**
     * Преобразует массив в список
     * @return
     */
    public ArrayList createListFromArray() {
        ArrayList<T> arrList = new ArrayList<>();
        for (Object element : this.arr)
            arrList.add((T)element);
        return arrList;
    }
}
