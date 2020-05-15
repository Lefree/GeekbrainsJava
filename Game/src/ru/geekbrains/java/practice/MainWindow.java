package ru.geekbrains.java.practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;

public class MainWindow extends JFrame {
    private static int POS_X = 400;
    private static int POS_Y = 200;
    private static int WINDOW_WIDTH = 800;
    private static int WINDOW_HEIGHT = 600;
    Sprite[] sprites = new Sprite[10];
    Background background;

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
                    addNewBall();
                else
                    removeLastBall();

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
        background = new Background();
        for (int i = 0; i < sprites.length; i++) {
            sprites[i] = new Ball();
        }

    }
    void onDrawFrame(MainCanvas canvas, Graphics g, float deltaTime) {
        update(canvas, deltaTime);
        render(canvas, g);
    }

    private void update(MainCanvas canvas, float deltaTime) {
        background.update(deltaTime);
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].update(canvas, deltaTime);
        }
    }

    private void render(MainCanvas canvas, Graphics g) {
        background.render(new Rectangle(canvas.getLeft(), canvas.getTop(),
                canvas.getWidth(), canvas.getHeight()), g);
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].render(canvas, g);
        }
    }

    private void addNewBall() {
        Sprite[] newSprites = new Sprite[sprites.length + 1];
        for (int i = 0; i < sprites.length; i++) {
            newSprites[i] = sprites[i];
        }
        for (int i = sprites.length; i < newSprites.length; i++) {
            newSprites[i] = new Ball();
        }
        sprites = newSprites;
    }

    private void removeLastBall() {
        if (sprites.length > 0) {
            Sprite[] newSprite = new Sprite[sprites.length - 1];
            for (int i = 0; i < newSprite.length; i++)
                newSprite[i] = sprites[i];
            sprites = newSprite;
        }
    }
}
