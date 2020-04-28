package ru.geekbrains.java.practice;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsWindow extends JFrame {
    private static final int WINDOW_WIDTH = 350;
    private static final int WINDOW_HEIGHT = 270;
    GameWindow gameWindow;

    private static final int MIN_WIN_LENGTH = 3;
    private static final int MIN_FIELD_SIZE = 3;
    private static final int MAX_FIELD_SIZE = 10;
    private static final String FIELD_SIZE_PREFIX = "Field size is: ";
    private static final String WIN_LENGTH_PREFIX = "Win length is: ";

    private static JRadioButton humVShum;
    private static JRadioButton humVSAI;
    private static JSlider slideWinLength;
    private static JSlider slideFieldSize;

    SettingsWindow(GameWindow gameWindow) {
        this.gameWindow = gameWindow;

        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        Rectangle gameWindowBounds = gameWindow.getBounds();
        int posX = (int) gameWindowBounds.getCenterX() - WINDOW_WIDTH / 2;
        int posY = (int) gameWindowBounds.getCenterY() - WINDOW_HEIGHT / 2;

        setLocation(posX, posY);
        setResizable(false);
        setTitle("Creating new game");
        setLayout(new GridLayout(10, 1));
        addGameModeControls();
        addFieldControls();
        JButton btnStart = new JButton("Start with current settings");
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                btnStartClicked();
            }
        });
        add(btnStart);
    }

    private void addGameModeControls() {
        add(new JLabel("Choose game mode"));
        humVShum = new JRadioButton("Human vs. Human");
        humVSAI = new JRadioButton("Human vs. AI", true);
        ButtonGroup groupMode = new ButtonGroup();
        groupMode.add(humVSAI);
        groupMode.add(humVShum);
        add(humVSAI);
        add(humVShum);
    }

    private void addFieldControls() {
        JLabel lbFieldSize = new JLabel(FIELD_SIZE_PREFIX + MIN_FIELD_SIZE);
        JLabel lbWinLength = new JLabel(WIN_LENGTH_PREFIX + MIN_WIN_LENGTH);
        slideFieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
        slideWinLength = new JSlider(MIN_WIN_LENGTH, MIN_FIELD_SIZE, MIN_FIELD_SIZE);

        slideWinLength.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                lbWinLength.setText(WIN_LENGTH_PREFIX + slideWinLength.getValue());
            }
        });

        slideFieldSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                int currentValue = slideFieldSize.getValue();
                lbFieldSize.setText(FIELD_SIZE_PREFIX + currentValue);
                slideWinLength.setMaximum(currentValue);
            }
        });

        add(new JLabel("Choose field size"));
        add(lbFieldSize);
        add(slideFieldSize);
        add(new JLabel("Choose win length"));
        add(lbWinLength);
        add(slideWinLength);
    }

    private void btnStartClicked() {
        int gameMode;
        if (humVSAI.isSelected()) {
            gameMode = Map.MODE_HVA;
        } else if (humVShum.isSelected()) {
            gameMode = Map.MODE_HVH;
        } else {
            throw new RuntimeException("Unknown game mode selected");
        }

        int fieldSize = slideFieldSize.getValue();
        int winLength = slideWinLength.getValue();
        gameWindow.startGame(gameMode, fieldSize, fieldSize, winLength);
        setVisible(false);
    }
}
