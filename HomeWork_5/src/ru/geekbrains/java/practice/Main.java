package ru.geekbrains.java.practice;

import ru.geekbrains.java.practice.zoo.*;

public class Main {

    public static void main(String[] args) {
        Animal dog = new Dog();
        Animal cat = new Cat();
        Animal blackCat = new Cat();
        Animal bird = new Bird();
        Animal horse = new Horse();
        blackCat.setRunLimitation(150);
        dog.run(350);
        dog.swim(300);
        dog.jump(2);
        System.out.println(blackCat.getInfo());
        cat.run(170);
        blackCat.run(170);
    }
}
