package ru.geekbrains.java.practice.common;

import java.awt.*;

public interface GameObject {
    void update(MainCanvas canvas, float deltaTime);

    void render(MainCanvas canvas, Graphics g);
}
