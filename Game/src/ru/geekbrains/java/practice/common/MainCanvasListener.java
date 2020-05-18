package ru.geekbrains.java.practice.common;

import java.awt.*;

public interface MainCanvasListener {
    void onDrawFrame(MainCanvas canvas, Graphics g, float deltaTime);
}
