package ru.geekbrains.java.practice.zoo;

import ru.geekbrains.java.practice.zoo.Animal;

public class Dog extends Animal {
    public Dog() {
        super(500, 10, 0.5f);
    }
    @Override
    public void run(int distance) {
        if (this.runLimitation >= distance)
            System.out.println("Песик пробежал " + distance + "м.");
        else
            System.out.println("Песик боится потеряться и не побежал так далеко");
    }
    @Override
    public void swim(int distance) {
        if (this.swimLimitation >= distance)
            System.out.println("Песик проплыл " + distance + "м.");
        else
            System.out.println("Песик смог проплыть лишь " + this.swimLimitation + "м.");
    }
    @Override
    public void jump(float height) {
        if (this.jumpLimitation >= height)
            System.out.println("Песик прыгнул аж " + height + "м.");
        else
            System.out.println("Слишком высоко");
    }
}
