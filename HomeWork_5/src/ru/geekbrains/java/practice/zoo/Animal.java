package ru.geekbrains.java.practice.zoo;

public abstract class Animal {
    protected int runLimitation;
    protected int swimLimitation;
    protected float jumpLimitation;

    protected Animal(int runLimitation, int swimLimitation, float jumpLimitation) {
        this.runLimitation = runLimitation;
        this.swimLimitation = swimLimitation;
        this.jumpLimitation = jumpLimitation;
    }

    public int getRunLimitation() {
        return this.runLimitation;
    }
    public int getSwimLimitation() {
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

    public abstract void run(int distance);
    public abstract void swim(int distance);
    public abstract void jump(float height);

    public String getInfo() {
        return "Инфо \n"
            + "Ограничение на бег: " + this.runLimitation + "\n"
            + "Ограничение на прыжок: " + this.jumpLimitation + "\n"
            + "Ограничение на плавание: " + this.swimLimitation + "\n";
    }

}
