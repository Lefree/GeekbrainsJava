package ru.geekbrains.java.practice;

import java.io.*;
import java.util.Calendar;
import java.util.Scanner;

public class Main {
    private static String absDirPath = "/home/alex/IdeaProjects/GeekbrainsJava/HomeWork_6/output/";

    public static void main(String[] args) {
        mergeFiles("file_1.txt", "file_2.txt");

        System.out.println(checkTextInFile(absDirPath + "output_3.txt",
                "Java"));
//        System.out.println(checkTextInDirectory(absDirPath, "java"));
    }

    /**
     * Метод записывает текст в файл.
     * @param text текст для записи
     */
    private static void writeToFile(String text) {
        File outputDirectory = new File("output");
        if (!outputDirectory.exists())
            outputDirectory.mkdir();
        String fileName = "output_" + Calendar.WEEK_OF_YEAR + ".txt";
        File newFile = new File(outputDirectory, fileName);
        try {
            PrintStream ps = new PrintStream(new FileOutputStream(newFile, true));
            ps.print(text);
            ps.println();
            ps.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод сливает все данные из переданных файлов в один
     * @param fileNames наименования файлов
     */
    private static void mergeFiles(String ...fileNames) {
        for (int i = 0; i < fileNames.length; i++) {
            try {
                Scanner scanner = new Scanner(new FileInputStream(fileNames[i]));
                while (scanner.hasNext())
                    writeToFile(scanner.nextLine());
                scanner.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Метод проверяет содержит ли файл фрагмент текста указанный пользователем
     * @param fileName Наименование файла для проверки
     * @param textToFind фрагмент текста для поиска
     * @return true/false
     */
    private static boolean checkTextInFile(String fileName, String textToFind) {
        char[] textInChars = textToFind.toCharArray();
        try {
            FileInputStream fis = new FileInputStream(fileName);
            int inputByte;
            int textPosition = 0;
            while ((inputByte = fis.read()) != -1) {
                if ((char) inputByte != textInChars[textPosition])
                    textPosition = 0;
                if ((char) inputByte == textInChars[textPosition])
                    textPosition++;
                if (textPosition == textInChars.length - 1)
                    return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return false;
}

    /**
     * Проверяет содержит ли хотя бы 1 файл из указанной дириктории фрагмент
     * текста указанный пользователем
     * @param dirPath Абсолютный путь до директории
     * @param textToFind фрагмент текста для поиска
     * @return true/false
     */
    private static boolean checkTextInDirectory(String dirPath, String textToFind) throws NullPointerException{
        File directory = new File(dirPath);
        File[] dirFilesList = directory.listFiles();
        for (int i = 0; i < dirFilesList.length; i++) {
            if (checkTextInFile(dirPath + dirFilesList[i].getName(), textToFind)) {
                return true;
            }
        }
        return false;
    }
}
