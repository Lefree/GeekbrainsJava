package ru.geekbrains.java.practice;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

import static ru.geekbrains.java.practice.MainClass.cdl2;
import static ru.geekbrains.java.practice.MainClass.cdl3;

public class Car implements Runnable {
    static int CARS_COUNT;
    static CountDownLatch cdl = new CountDownLatch(1);
    static CyclicBarrier cb;

    static {
        CARS_COUNT = 0;
    }
    private Race race;
    private int speed;
    private String name;
    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    private void prepareToRace() throws InterruptedException {
        System.out.println(this.name + " готовится");
        Thread.sleep(500 + (int)(Math.random() * 800));
    }

    @Override
    public void run() {
        try {
            prepareToRace();
            System.out.println(this.name + " готов");
            try {
                cb.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            cdl2.countDown();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        cdl.countDown();
        race.winner = new String(this.name);
        cdl3.countDown();
    }
}