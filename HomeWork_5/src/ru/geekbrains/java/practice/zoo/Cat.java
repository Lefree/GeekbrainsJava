package ru.geekbrains.java.practice.zoo;

import ru.geekbrains.java.practice.zoo.Animal;

public class Cat extends Animal {
    public Cat() {
        super("Cat",200, 0, 2);
    }

    public int swim(int distance) {
        return super.SWIM_WTF;
    }
}
