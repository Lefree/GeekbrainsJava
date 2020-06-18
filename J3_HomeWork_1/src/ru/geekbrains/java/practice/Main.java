package ru.geekbrains.java.practice;

public class Main {

    public static void main(String[] args) {
        Apple a1 = new Apple(1);
        Apple a2 = new Apple(0.4);
        Orange o1 = new Orange(0.3);
        Orange o2 = new Orange(0.4);
        Box<Apple> b1 = new Box<>(1, a1, a2);
        Box<Orange> b2 = new Box<>(0.8, o1, o2);
        System.out.println(b1.getWeight());
        System.out.println(b2.getWeight());
        System.out.println(b1.compareWithAnotherBox(b2));
        Orange o3 = new Orange(0.5);
        Orange o4 = new Orange(0.4);
        b2.addFruit(o3);
        b2.addFruit(o4);
        System.out.println(b1.compareWithAnotherBox(b2));
        Box<Apple> b3 = new Box<>(0.4);
        System.out.println(b3.getWeight());
        b1.moveFruitToAnotherBox(b3);
        System.out.println(b1.getWeight());
        System.out.println(b3.getWeight());
    }




}
