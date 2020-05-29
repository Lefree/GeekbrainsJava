package ru.geekbrains.java.practice.phonebook;

import java.util.Objects;

public class Person {

    private String lastName;
    private String phoneNumber;
    private String email;

    public Person(String lastName, String phoneNumber, String email) {
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Person(String lastName, String contact) {
        this.lastName = lastName;
        if (contact.contains("@")) {
            this.email = contact;
            this.phoneNumber = new String("");
        }
        else {
            this.phoneNumber = contact;
            this.email = new String("");
        }
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getMail() {
        return this.email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return lastName.equals(person.lastName) &&
                Objects.equals(this.phoneNumber, person.phoneNumber) &&
                Objects.equals(this.email, person.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, phoneNumber, email);
    }

    @Override
    public String toString() {
        return String.format("Lastname: %s \n Phone: %s \n Email: %s \n", lastName, phoneNumber, email);
    }
}
