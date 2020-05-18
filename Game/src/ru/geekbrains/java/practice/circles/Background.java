package ru.geekbrains.java.practice.circles;

import ru.geekbrains.java.practice.common.GameObject;
import ru.geekbrains.java.practice.common.MainCanvas;

import java.awt.*;

public class Background implements GameObject {
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
