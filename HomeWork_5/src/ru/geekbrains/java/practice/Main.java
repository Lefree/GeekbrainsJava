package ru.geekbrains.java.practice;

import ru.geekbrains.java.practice.zoo.*;

public class Main {

    public static void main(String[] args) {
        Animal dog = new Dog();
        Animal cat = new Cat();
        Animal bird = new Bird();
        Animal horse = new Horse();
        Animal[] zoo = {dog, cat, bird, horse};
        int runDistance = 250;
        int jumpHeight = 3;
        int swimDistance = 20;
        for (int i = 0; i < zoo.length; i++) {
            if (zoo[i].run(runDistance))
                System.out.println(zoo[i].getType() + " run " + runDistance + " meters");
            else
                System.out.println(zoo[i].getType() + " can run less than "
                    + zoo[i].getRunLimitation() + " meters");
            if (zoo[i].jump(jumpHeight))
                System.out.println(zoo[i].getType() + " jumped " + jumpHeight + " meters");
            else
                System.out.println(zoo[i].getType() + " can jump less than "
                        + zoo[i].getJumpLimitation() + " meters");

            switch (zoo[i].swim(swimDistance)) {
                case 1:
                    System.out.println(zoo[i].getType() + " swam " + swimDistance + " meters");
                    break;
                case 0:
                    System.out.println(zoo[i].getType() + " can swim less than "
                            + zoo[i].getSwimLimitation() + " meters");
                    break;
                case -1:
                    System.out.println(zoo[i].getType() + " can`t swim");
            }
            System.out.println();
        }
    }
}
