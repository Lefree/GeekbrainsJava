package ru.geekbrains.java.practice.phonebook;

import java.util.Objects;

public class Person {
    class Contacts {
        private String phoneNumber;
        private String email;

        public String getEmail() {
            return email;
        }
        public String getPhoneNumber() {
            return phoneNumber;
        }
        public String toString() {
            return String.format("Phone: %s; Email: %s", this.phoneNumber, this.email);
        }
    }
    private String lastName;
    private Contacts contacts = new Contacts();

    public Person(String lastName, String phoneNumber, String email) {
        this.lastName = lastName;
        this.contacts.phoneNumber = phoneNumber;
        this.contacts.email = email;
    }

    public Person(String lastName, String contact) {
        this.lastName = lastName;
        if (contact.contains("@")) {
            this.contacts.email = contact;
            this.contacts.phoneNumber = new String("");
        }
        else {
            this.contacts.phoneNumber = contact;
            this.contacts.email = new String("");
        }
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getPhoneNumber() {
        return this.contacts.getPhoneNumber();
    }

    public String getMail() {
        return this.contacts.getEmail();
    }

    public Contacts getContacts() {
        return this.contacts;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return lastName.equals(person.lastName) &&
                Objects.equals(this.contacts.phoneNumber, person.contacts.phoneNumber) &&
                Objects.equals(this.contacts.email, person.contacts.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, contacts.phoneNumber, contacts.email);
    }
}
