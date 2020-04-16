package ru.geekbrains.java.practice;

public class Employee {
    private String fullName;
    private int age;
    private int salary;
    private int id;

    /**
     * Конструктор для инициализации объекта
     * @param fullName ФИО сотрудника
     * @param age возраст сотрудника
     * @param salary заработная плата сотрудника
     */
    public Employee(String fullName, int age, int salary) {
        this.fullName = fullName;
        this.age = age;
        this.salary = salary;
        int hash = 7;
        hash = 31 * hash + this.age;
        hash = 31 * hash + (this.fullName == null ? 0 : this.fullName.hashCode());
        this.id = hash > 0 ? hash : -hash;
    }

    /**
     * Метод для получения ФИО сотрудника
     * @return String ФИО
     */
    public String getFullName() {
        return this.fullName;
    }

    /**
     * Метод для получения значения возраста сотрудника
     * @return int Возраст сотрудника
     */
    public int getAge() {
        return this.age;
    }

    /**
     * Метод для получения значения заработной платы сотрудника
     * @return int Заработная плата
     */
    public int getSalary() {
        return this.salary;
    }

    /**
     * Метод для изменения значения поля заработная плата сотрудника
     * @param newSalary Новое значение заработной платы
     */
    public void setSalary(int newSalary) {
        if (newSalary > 0)
            this.salary = newSalary;
    }

    /**
     * Метод для изменения ФИО сотрудника
     * @param newFullName Новое значение ФИО
     */
    public void setFullName(String newFullName) {
        if (newFullName.length() > 0)
            this.fullName = newFullName;
    }

    /**
     * Метод для изменения значения поля возраст сотрудника
     * @param newAge Новое значение для поля возраст
     */
    public void setAge(int newAge) {
        if (newAge > 0) {
            this.age = newAge;
        }
    }
}
