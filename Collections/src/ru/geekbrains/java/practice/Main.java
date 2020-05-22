package ru.geekbrains.java.practice;

import ru.geekbrains.java.practice.phonebook.Person;
import ru.geekbrains.java.practice.phonebook.PhoneBook;

import java.util.*;

public class Main {
    private static final String text = "This class consists exclusively of static methods that operate " +
        "on or return collections It contains polymorphic algorithms that operate on collections wrappers " +
        "which return a new collection backed by a specified collection and a few other odds and ends";

    public static void main(String[] args) {
        System.out.println(getWordsList(text));
        HashMap<String, Integer> wordsCount = getWordCountsMap(text);
        for(String key : wordsCount.keySet()) {
            System.out.println(key + ": " + wordsCount.get(key));
        }
        Person p = new Person("Ivanov", "89001231213", "vanko@mail.ru");
        PhoneBook ph = new PhoneBook();
        ph.addContact(p);
        ph.addContact("Petrov", "89611323443", "petro@gmail.com");
        ph.addContact("Ivanov", "89183221666");
        ph.addContact("Petrov", "pit@yahoo.com");
        System.out.println(ph);
        try {
            System.out.println(ph.getPhonesByLastName("Ivanov"));
            System.out.println(ph.getEmailsByLastName("Petrov"));
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }

    }

    private static ArrayList<String> getWordsList(String s) {
        HashSet<String> tempSet = new HashSet<>();
        ArrayList<String> resultArrayList = new ArrayList<>();
        tempSet.addAll(Arrays.asList(s.toLowerCase().split(" ")));
        resultArrayList.addAll(tempSet);
        return resultArrayList;
    }

    private static HashMap<String, Integer> getWordCountsMap(String s) {
        HashMap<String, Integer> wordsCount = new HashMap<>();
        for (String word: s.toLowerCase().split(" ")) {
            if (wordsCount.get(word) != null)
                wordsCount.put(word, wordsCount.get(word) + 1);
            else
                wordsCount.put(word, 1);
        }
        return wordsCount;
    }

}
