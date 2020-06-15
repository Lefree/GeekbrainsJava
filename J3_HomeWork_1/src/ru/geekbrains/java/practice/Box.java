package ru.geekbrains.java.practice;

import java.util.ArrayList;
import java.util.Iterator;

public class Box<T extends Fruit> {
    private double weight;
    private ArrayList<T> storage = new ArrayList<>();

    public Box(double weight, T... fruits) {
        this.weight = weight;
        for (T fruit : fruits)
            storage.add(fruit);
    }

    public double getWeight() {
        double totalWeight = this.weight;
        for (T fruit: storage)
            totalWeight += fruit.getWeight();
        return totalWeight;
    }

    public boolean compareWithAnotherBox(Box box) {
        return this.getWeight() == box.getWeight();
    }

    public void addFruit(T fruit) {
        this.storage.add(fruit);
    }

    public void moveFruitToAnotherBox(Box box) {
        Iterator<T> iterator = storage.iterator();
        while (iterator.hasNext()) {
            box.addFruit(iterator.next());
            iterator.remove();
        }
    }
}
