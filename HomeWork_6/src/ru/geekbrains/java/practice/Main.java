package ru.geekbrains.java.practice;

import java.io.*;
import java.util.Scanner;

public class Main {
    private static int fileId;
    private static String absDirPath = "/home/alex/IdeaProjects/GeekbrainsJava/HomeWork_6/output/";

    public static void main(String[] args) {
        mergeFiles("file_1.txt", "file_2.txt");

        System.out.println(checkTextInFile(absDirPath + "output.txt", "java"));
        System.out.println(checkTextInDirectory(absDirPath, "java"));
    }

    /**
     * Метод записывает текст в файл.
     * @param text текст для записи
     * @return String -имя нового файла
     */
    private static String writeToFile(String text) {
        File outputDirectory = new File("output");
        if (!outputDirectory.exists())
            outputDirectory.mkdir();
        String fileName = "output_" + ++fileId + ".txt";
        File newFile = new File(outputDirectory, fileName);
        try {
            PrintStream ps = new PrintStream(new FileOutputStream(newFile));
            ps.print(text);
            ps.println();
            ps.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return fileName;
    }

    /**
     * Метод вычитывает всю информацию из файла
     * @param fileName имя файла для чтения
     * @return String - весь текст файла как единая строка
     */
    private static String readAllFromFile(String fileName) {
        StringBuilder sb = new StringBuilder();
        try {
            Scanner scanner = new Scanner(new FileInputStream(fileName));
            while (scanner.hasNext())
                sb.append(scanner.nextLine());
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    /**
     * Метод сливает все данные из переданных файлов в один
     * @param fileNames наименования файлов
     * @return String - имя нового файла, в который записались все данные
     */
    private static String mergeFiles(String ...fileNames) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < fileNames.length; i++) {
            sb.append(readAllFromFile(fileNames[i]));
        }
        return writeToFile(sb.toString());
    }

    /**
     * Метод проверяет содержит ли файл фрагмент текста указанный пользователем
     * @param fileName Наименование файла для проверки
     * @param textToFind фрагмент текста для поиска
     * @return true/false
     */
    private static boolean checkTextInFile(String fileName, String textToFind) {
        String fileText = readAllFromFile(fileName);
        return fileText.toLowerCase().indexOf(textToFind.toLowerCase()) >= 0;
    }

    /**
     * Проверяет содержит ли хотя бы 1 файл из указанной дириктории фрагмент
     * текста указанный пользователем
     * @param dirPath Абсолютный путь до директории
     * @param textToFind фрагмент текста для поиска
     * @return true/false
     */
    private static boolean checkTextInDirectory(String dirPath, String textToFind) {
        boolean textInDirectory = false;
        File directory = new File(dirPath);
        File[] dirFilesList = directory.listFiles();
        for (int i = 0; i < dirFilesList.length; i++) {
            if (checkTextInFile(dirPath + dirFilesList[i].getName(), textToFind)) {
                textInDirectory = true;
                return textInDirectory;
            }
        }
        return textInDirectory;
    }
}
