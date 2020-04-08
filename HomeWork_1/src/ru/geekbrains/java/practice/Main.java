package ru.geekbrains.java.practice;

public class Main {

    public static void main(String[] args) {

        // Задание 2
        byte byteValue = -127;
        short shortValue = 1000;
        int intValue = 21221;
        long longValue = 1000L;

        float floatValue = 21.22f;
        double doubleValue = 3.14;

        char charValue = 'X';
        boolean booleanValue = false;

        // Проверка выполнения метода для задания 3
        System.out.println(countExpression(2, 4, 10, 2));

        //Проверка выполнения метода для задания 4
        System.out.println(checkSumRange(41, 13));

        //Проверка выполнения метода для задания 5
        System.out.println(checkNumberSign(21));

        //Проверка выполнения метода для задания 6
        System.out.println(isNegative(-24));

        //Проверка выполнения метода для задания 7
        System.out.println(greeting("Alex"));

        //Проверка выполнения для задания 8
        System.out.println(checkYear(2003));
    }

    /**
     * Задание 3
     * Написать метод, вычисляющий выражение a * (b + (c / d))
     */
    private static float countExpression(float a, float b, float c, float d) {
        float resultValue = 0.0f;
        if (d == 0) {
            System.out.println("Введенный параметр d должен быть отличен от 0");
        } else {
            resultValue = a * (b + (c / d));
        }
        return resultValue;
    }

    /**
     * Задание 4. Проверка вхождения суммы двух целых чисел в промежуток
     * от 10 до 20 включительно
     * @param x 1-ое целое число
     * @param y 2-ое целое число
     */
    private static boolean checkSumRange(int x, int y) {
        int sum = x + y;
        return sum >= 10 && sum <= 20;
    }

    /**
     * Задание 5. Проверить число на знак. Вывести в соответствии со знаком
     * положительное или отрицательное число.
     */
    private static String checkNumberSign(int x) {
        String resultMsg;
        resultMsg = x >= 0
            ? "Число " + x + " положительное"
            : "Число " + x + " отрицательное";
        return resultMsg;
    }

    /**
     * Задание 6. Проверить является ли число отрицательным.
     */
    private static boolean isNegative(int x) {
        return x < 0;
    }

    /**
     * Задание 7. Написать приветствующий метод.
     */
    public static String greeting(String name) {

        return "Привет, " + name + "!";
    }

    /**
     * Задание 8. Написать метод, который определяет
     * является ли год високосным
     */
    private static String checkYear(int year) {
        String resultMsg = year + " не является високосным годом";
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                resultMsg = year + " является високосным годом";
            }
        return resultMsg;
    }
}
