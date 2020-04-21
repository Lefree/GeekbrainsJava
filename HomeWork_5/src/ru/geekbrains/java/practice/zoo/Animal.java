package ru.geekbrains.java.practice.zoo;

import java.util.Random;

public abstract class Animal {
    protected final int SWIM_OK = 1;
    protected final int SWIM_FAIL = 0;
    protected final int SWIM_WTF = -1;

    private String type;
    private float runLimitation;
    private float swimLimitation;
    private float jumpLimitation;
    private final Random random = new Random();

    protected Animal(String type, float runLimitation, float swimLimitation, float jumpLimitation) {
        this.type = type;
        this.runLimitation = createVariation(runLimitation);
        this.swimLimitation = createVariation(swimLimitation);
        this.jumpLimitation = createVariation(jumpLimitation);
    }
    private float createVariation(float reference) {
        return reference + random.nextFloat() * reference - (reference / 2);
    }
    public String getType() {
        return this.type;
    }
    public float getRunLimitation() {
        return this.runLimitation;
    }
    public float getSwimLimitation() {
        return this.swimLimitation;
    }
    public float getJumpLimitation() {
        return this.jumpLimitation;
    }
    public void setRunLimitation(int limit) {
        this.runLimitation = limit > 0 ? limit : 0;
    }
    public void setSwimLimitation(int limit) {
        this.swimLimitation = limit > 0 ? limit : 0;
    }
    public void setJumpLimitation(float limit) {
        this.jumpLimitation = limit > 0 ? limit : 0f;
    }

    public boolean run(int distance) {
        return distance <= this.runLimitation;
    }
    public int swim(int distance) {
        return (distance <= this.swimLimitation) ? this.SWIM_OK : this.SWIM_FAIL;
    }
    public boolean jump(float height) {
        return height <= this.jumpLimitation;
    }

    public String getInfo() {
        return "Инфо \n"
            + "Ограничение на бег: " + this.runLimitation + "\n"
            + "Ограничение на прыжок: " + this.jumpLimitation + "\n"
            + "Ограничение на плавание: " + this.swimLimitation + "\n";
    }

}
