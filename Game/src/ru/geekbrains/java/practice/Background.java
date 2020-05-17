package ru.geekbrains.java.practice;

import java.awt.*;

public class Background extends Sprite{
    private Color color ;
    private static final float AMPLITUDE = 255f / 2f;
    private float currentBackgroundDuration;

    public void update(MainCanvas canvas, float deltaTime) {
        currentBackgroundDuration += deltaTime;
        int red = Math.round(AMPLITUDE + AMPLITUDE * (float)Math.sin(currentBackgroundDuration));
        int green = Math.round(AMPLITUDE + AMPLITUDE * (float)Math.sin(2 * currentBackgroundDuration));
        int blue = Math.round(AMPLITUDE + AMPLITUDE * (float)Math.sin(3 * currentBackgroundDuration));
        color = new Color(red, green, blue);
    }

    public void render(MainCanvas canvas, Graphics g) {
        canvas.setBackground(color);
    }
}
