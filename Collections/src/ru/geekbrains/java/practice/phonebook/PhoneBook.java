package ru.geekbrains.java.practice.phonebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class PhoneBook {

    class SearchCache {
        private String lastName;
        private ArrayList<String> emails;
        private ArrayList<String> phones;

        SearchCache(String lastName) {
            this.lastName = lastName;
            emails = new ArrayList<>();
            phones = new ArrayList<>();
        }
    }

    HashMap<String, LinkedList<Person>> book;
    SearchCache cache;
    public PhoneBook() {
        this.book = new HashMap<>();
    }
    public void addContact(Person p) {
        if (book.containsKey(p.getLastName()))
            book.get(p.getLastName()).add(p);
        else
            book.put(p.getLastName(), new LinkedList<Person>(Arrays.asList(p)));
    }

    public void addContact(String lastName, String phoneNumber, String email) {
        addContact(new Person(lastName, phoneNumber, email));
    }

    public void addContact(String lastName, String contact) {
        addContact(new Person(lastName, contact));
    }

    private void findContacts(String lastName) throws NullPointerException{
        cache = new SearchCache(lastName);
        try {
            for(Person c : book.get(lastName)) {
                if(!c.getPhoneNumber().equals(""))
                    cache.phones.add(c.getPhoneNumber());
                if (!c.getMail().equals(""))
                    cache.emails.add(c.getMail());
            }
        } catch (NullPointerException e) {
            throw new NullPointerException("Not found any data by this lastname");
        }
    }

    public ArrayList<String> getPhonesByLastName(String lastName) throws NullPointerException{
        if (cache == null || !cache.lastName.equals(lastName))
            findContacts(lastName);
        return cache.phones;
    }

    public ArrayList<String> getEmailsByLastName(String lastName) throws NullPointerException {
        if (cache == null || !cache.lastName.equals(lastName))
            findContacts(lastName);
        return cache.emails;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (String key : book.keySet()) {
            s.append(key + ": " + book.get(key));
        }
        return s.toString();
    }
}
