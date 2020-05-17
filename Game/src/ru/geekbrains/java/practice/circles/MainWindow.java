package ru.geekbrains.java.practice.circles;

import ru.geekbrains.java.practice.common.GameObject;
import ru.geekbrains.java.practice.common.MainCanvas;
import ru.geekbrains.java.practice.common.MainCanvasListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MainWindow extends JFrame implements MainCanvasListener{
    private static int POS_X = 400;
    private static int POS_Y = 200;
    private static int WINDOW_WIDTH = 800;
    private static int WINDOW_HEIGHT = 600;
    private GameObject[] gameObjects = new GameObject[1];
    private int gameObjectsCount;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainWindow();
            }
        });
    }

    private MainWindow() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setResizable(false);
        MainCanvas canvas = new MainCanvas(this);
        canvas.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
                if (SwingUtilities.isLeftMouseButton(mouseEvent))
                    addGameObject(new Ball());
                else
                    removeGameObject();

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {

            }
        });
        initApplication();
        add(canvas);
        setTitle("Circles");
        setVisible(true);
    }

    private void initApplication() {
        gameObjects[0] = new Background();
        gameObjectsCount++;
    }

    public void onDrawFrame(MainCanvas canvas, Graphics g, float deltaTime) {
        update(canvas, deltaTime);
        render(canvas, g);
    }

    private void update(MainCanvas canvas, float deltaTime) {
        for (int i = 0; i < gameObjectsCount; i++) {
            gameObjects[i].update(canvas, deltaTime);
        }
    }

    private void render(MainCanvas canvas, Graphics g) {
        for (int i = 0; i < gameObjectsCount; i++) {
            gameObjects[i].render(canvas, g);
        }
    }

    private void addGameObject(GameObject s) {
        if (gameObjects.length == gameObjectsCount) {
            GameObject[] temp = new GameObject[gameObjects.length * 2];
            System.arraycopy(gameObjects, 0, temp, 0, gameObjects.length);
            gameObjects = temp;
        }
        gameObjects[gameObjectsCount++] = s;
    }

    private void removeGameObject() {
        if (gameObjectsCount > 0)
            gameObjectsCount--;
        }
}
