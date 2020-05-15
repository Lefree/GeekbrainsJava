package ru.geekbrains.java.practice;

import java.awt.*;

public class Background {
    Color color = new Color((int)(Math.random() * 255),
            (int)(Math.random() * 255),
            (int)(Math.random() * 255));
    float currentBackgroundDuration = 0f;
    float maxBackgroundDuration = 15f;

    public void update(float deltaTime) {
        currentBackgroundDuration += deltaTime;
        if (currentBackgroundDuration > maxBackgroundDuration) {
            color = new Color((int)(Math.random() * 255),
                    (int)(Math.random() * 255),
                    (int)(Math.random() * 255));
            currentBackgroundDuration = 0;
        }
    }

    public void render(Rectangle rect, Graphics g) {
        g.setColor(color);
        g.fillRect((int)rect.getX(), (int)rect.getY(),
                (int)rect.getWidth(), (int)rect.getHeight());

    }
}
