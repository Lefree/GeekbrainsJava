package ru.geekbrains.java.practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

public class GameWindow extends JFrame {

    private static final int WIN_WIDTH = 507;
    private static final int WIN_HEIGHT = 555;
    private static final int WIN_POSX = 650;
    private static final int WIN_POSY = 250;
    private final SettingsWindow settingsWindow;
    private Map map;

    GameWindow() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Tic Tac Toe");
        setSize(WIN_WIDTH, WIN_HEIGHT);
        setLocation(WIN_POSX, WIN_POSY);
        JButton btnStart = new JButton("Start new game");
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                settingsWindow.setVisible(true);
            }
        });
        JButton btnExit = new JButton("Exit game");
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
        JPanel panelBottom = new JPanel(new GridLayout(1, 2));
        panelBottom.add(btnStart);
        panelBottom.add(btnExit);
        map = new Map();
        settingsWindow = new SettingsWindow(this);
        add(panelBottom, BorderLayout.SOUTH);
        add(map);
        setVisible(true);
    }

    void startGame(int gameMode, int fieldSizeX, int fieldSizeY, int winLenght) {
        map.startNewGame(gameMode, fieldSizeX, fieldSizeY, winLenght);
    }
}
