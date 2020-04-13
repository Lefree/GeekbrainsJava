package ru.geekbrains.java.practice;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    //field sizes & map
    private static int fieldSizeY;
    private static int fieldSizeX;
    private static char[][] map;

    private static final char HUMAN_DOT = 'X';
    private static final char AI_DOT = 'O';
    private static final char EMPTY_DOT = '.';
    private static int scoresToWin;

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        while (true) {
            initMap();
            printMap();
            while (true) {
                humanTurn();
                printMap();
                if (checkWin(HUMAN_DOT)) {
                    System.out.println("Human win");
                    break;
                }
                aiTurn();
                printMap();
                if (checkWin(AI_DOT)) {
                    System.out.println("AI win");
                    break;
                }
                if (isMapFull()) {
                    System.out.println("Draw");
                    break;
                }
            }
            System.out.println("Play again?");
            if(!SCANNER.next().equals("Y"))
                break;
        }
    }

    /**
     * Инициализация игрового поля
     */
    private static void initMap() {
        fieldSizeY = 5;
        fieldSizeX = 5;
        scoresToWin = 4;
        map = new char[fieldSizeY][fieldSizeX];
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                map[y][x] = EMPTY_DOT;
            }
        }
    }

    /**
     * Отрисовка игрового поля
     */
    private static void printMap() {
        System.out.println("-------");
        for (int y = 0; y < fieldSizeY; y++) {
            System.out.print("|");
            for (int x = 0; x < fieldSizeX; x++) {
                System.out.print(map[y][x] + "|");
            }
            System.out.println();
        }
    }

    /**
     * Осуществление хода человеком
     */
    private static void humanTurn() {
        int y;
        int x;
        do {
            System.out.println("Введите координаты хода X и Y через пробел");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!(isCellEmpty(y, x)) && !(isCellValid(y, x)));
        map[y][x] = HUMAN_DOT;
    }

    /**
     * Проверка заполненности клетки с указанными координатами
     * @param y координата столбца
     * @param x координата строки
     * @return true/false
     */
    private static boolean isCellEmpty(int y, int x) {
        return map[y][x] == EMPTY_DOT;
    }

    /**
     *  Проверка попадания координат в границы игрового поля
     * @param y координата столбца
     * @param x координата строки
     * @return true/false
     */
    private static boolean isCellValid(int y, int x) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    /**
     * Проверка заполненности игрового поля
     * @return true/false
     */
    private static boolean isMapFull() {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (isCellEmpty(y, x)) return false;
            }
        }
        return true;
    }

    /**
     * Проверка победы определенного игрока
     * @param dot символ игрока для проверки
     * @return true/false
     */
    private static boolean checkWin(char dot) {
            return checkDiagonals(dot) || checkLines(dot);
    }

    /**
     * Подсчет количества подряд идущих совпадений
     * @param fieldDot текущая клетка поля
     * @param dot символ игрока для проверки
     * @param currentScore текущее количество подряд идущих символов
     * @return int новое количество совпадений с символом игрока
     */
    private static int getCurrentScore(char fieldDot, char dot, int currentScore) {
        if (fieldDot == dot) currentScore++;
        else currentScore = currentScore >= scoresToWin ? currentScore : 0;
        return currentScore;
    }

    /**
     * Проверка выйгрышных вертикальных/горизонтальных линий
     * @param dot символ игрока для проверки
     * @return true/false - найдена или не найдена победная комбинация
     */
    private static boolean checkLines(char dot) {
        for (int y = 0; y < fieldSizeY; y++) {
            int hScores = 0;
            int vScores = 0;
            for (int x = 0; x < fieldSizeX; x++) {
                vScores = getCurrentScore(map[x][y], dot, vScores);
                hScores = getCurrentScore(map[y][x], dot, hScores);
            }
            if (hScores >= scoresToWin || vScores >= scoresToWin) return true;
        }
        return false;
    }

    /**
     * Проверка выйгрышных диагоналей и поддиагоналей при размерности больше 3
     * @param dot символ игрока для проверки
     * @return true/false - найдена или не найдена победная комбинация
     */
    private static boolean checkDiagonals(char dot) {
        int size = fieldSizeY < fieldSizeX ? fieldSizeY : fieldSizeX;
        int mainScore = 0;
        int secondaryScore = 0;
        for (int i = 0; i < size; i++) {
            mainScore = getCurrentScore(map[i][i], dot, mainScore);
            secondaryScore = getCurrentScore(map[i][fieldSizeX - i - 1], dot, secondaryScore);
        }

        if (size > scoresToWin) {
            int aboveMainScore = 0;
            int aboveSecondaryScore = 0;
            int underMainScore = 0;
            int underSecondaryScore = 0;
            int delta = size - scoresToWin;
            for (int j = 1; j <= delta; j++) {
                for (int i = 0; i < size - delta; i++) {
                    underMainScore = getCurrentScore(map[i + j][i], dot, underMainScore);
                    underSecondaryScore = getCurrentScore(map[i + j][fieldSizeX - i - 1], dot, underSecondaryScore);
                    aboveMainScore = getCurrentScore(map[i][i + j], dot, aboveMainScore);
                    aboveSecondaryScore = getCurrentScore(map[i][fieldSizeX - i - 1 - j], dot, aboveSecondaryScore);
                }
                if (underMainScore >= scoresToWin || underSecondaryScore >= scoresToWin
                || aboveMainScore >= scoresToWin || aboveSecondaryScore >= scoresToWin) return true;
            }
        }
        return (mainScore >= scoresToWin || secondaryScore >= scoresToWin);
    }

    /**
     * Ход компьютера
     */
    private static void aiTurn() {
        int i = 0;
        int j = 0;
        int max = 0;
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if(isCellEmpty(y, x)) {
                    if (countTurnRate(y, x, AI_DOT) > max) {
                        max = countTurnRate(y, x, AI_DOT);
                        i = y;
                        j = x;
                    }
                }
            }
        }
        map[i][j] = AI_DOT;
    }

    /**
     * Расчет рейтинга для хода компьютера
     * @param y координата столбца
     * @param x координата строки
     * @param dot символ игрока
     * @return рейтинг хода
     */
    private static int countTurnRate(int y, int x, char dot) {
        int count = 0;
        map[y][x] = dot;
        if (checkWin(dot)) count = 100;
        map[y][x] = HUMAN_DOT;
        if (checkWin(HUMAN_DOT)) count += 50;
        else if ((y == 0 || y == fieldSizeY - 1) && (x == 0 || x == fieldSizeX - 1)) count += 25;
        else count += 20;
        map[y][x] = EMPTY_DOT;
        return count;
    }
}
