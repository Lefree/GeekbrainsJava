package ru.geekbrains.java.practice.zoo;

import ru.geekbrains.java.practice.zoo.Animal;

public class Cat extends Animal {
    public Cat() {
        super(200, 0, 2);
    }

    @Override
    public void run(int distance) {
        if (this.runLimitation >= distance)
            System.out.println("Котик пробежал " + distance + "м.");
        else
            System.out.println("Котик поленился бежать так далеко");
    }
    @Override
    public void swim(int distance) {
        System.out.println("Котик не умеет плавать:(");
    }
    @Override
    public void jump(float height) {
        if (this.jumpLimitation >= height)
            System.out.println("Котик прыгнул аж " + height + "м.");
        else
            System.out.println("Слишком высоко");
    }
}
