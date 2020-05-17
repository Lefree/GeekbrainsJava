package ru.geekbrains.java.practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MainWindow extends JFrame {
    private static int POS_X = 400;
    private static int POS_Y = 200;
    private static int WINDOW_WIDTH = 800;
    private static int WINDOW_HEIGHT = 600;
    private Sprite[] sprites = new Sprite[1];
    private int spritesCount;

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
                    addNewSprite(new Ball());
                else
                    removeSprite();

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
        sprites[0] = new Background();
        spritesCount++;
    }

    void onDrawFrame(MainCanvas canvas, Graphics g, float deltaTime) {
        update(canvas, deltaTime);
        render(canvas, g);
    }

    private void update(MainCanvas canvas, float deltaTime) {
        for (int i = 0; i < spritesCount; i++) {
            sprites[i].update(canvas, deltaTime);
        }
    }

    private void render(MainCanvas canvas, Graphics g) {
        for (int i = 0; i < spritesCount; i++) {
            sprites[i].render(canvas, g);
        }
    }

    private void addNewSprite(Sprite s) {
        if (sprites.length == spritesCount) {
            Sprite[] newSprites = new Sprite[sprites.length * 2];
            System.arraycopy(sprites, 0, newSprites, 0, sprites.length);
            sprites = newSprites;
        }
        sprites[spritesCount++] = s;
    }

    private void removeSprite() {
        if (spritesCount > 0)
            spritesCount--;
        }
}
