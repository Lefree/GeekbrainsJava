package ru.geekbrains.java.practice.zoo;

import ru.geekbrains.java.practice.zoo.Animal;

public class Horse extends Animal {
    public Horse() {
        super(1500, 100, 3);
    }
    @Override
    public void run(int distance) {
        if (this.runLimitation >= distance)
            System.out.println("Лошадь проскакала " + distance + "м.");
        else
            System.out.println("Лошадь отказалась бежать так далеко");
    }
    @Override
    public void swim(int distance) {
        if (this.swimLimitation >= distance)
            System.out.println("Лошадь проплыла " + distance + "м.");
        else
            System.out.println("Лошадь отказывается плыть так далеко");
    }
    @Override
    public void jump(float height) {
        if (this.jumpLimitation >= height)
            System.out.println("Лошадь прыгнула аж " + height + "м.");
        else
            System.out.println("Слишком высоко");
    }
}
