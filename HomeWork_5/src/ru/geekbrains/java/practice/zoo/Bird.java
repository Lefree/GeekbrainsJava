package ru.geekbrains.java.practice.zoo;

import ru.geekbrains.java.practice.zoo.Animal;

public class Bird extends Animal {
    public Bird() {
        super(5, 0, 0.2f);
    }
    @Override
    public void run(int distance) {
        if (this.runLimitation >= distance)
            System.out.println("Птичка пролетела " + distance + "м.");
        else
            System.out.println("Зачем птичке так далеко бежать, если можно лететь");
    }
    @Override
    public void swim(int distance) {
        System.out.println("Птичка не умеет плавать");
    }
    @Override
    public void jump(float height) {
        if (this.jumpLimitation >= height)
            System.out.println("Птичка прыгнула аж " + height + "м.");
        else
            System.out.println("Слишком высоко");
    }
}
