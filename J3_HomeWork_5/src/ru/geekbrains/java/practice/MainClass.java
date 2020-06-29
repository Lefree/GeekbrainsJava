package ru.geekbrains.java.practice;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class MainClass {
    public static final int CARS_COUNT = 4;
    static CountDownLatch cdl2;
    static CountDownLatch cdl3;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }
        cdl2 = new CountDownLatch(4);
        cdl3 = new CountDownLatch(4);
        Car.cb = new CyclicBarrier(4);
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }
        cdl2.await();
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        Car.cdl.await();
        System.out.println(Race.winner + " - WIN!");
        cdl3.await();
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }
}