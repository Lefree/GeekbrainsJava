package ru.geekbrains.java.practice;

public class Main {

    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Ivanov Oleg", 24, 70000);
        employees[1] = new Employee("Petrov Ivan", 31, 85000);
        employees[2] = new Employee("Sidorov Fedor", 50, 20000);
        employees[3] = new Employee("Stepanov Maxim", 26, 45000);
        employees[4] = new Employee("Stepanov Igor", 46,30000);

        System.out.println("Task #4");
        for (int i = 0; i < employees.length; i++)
            System.out.printf("ФИО: %s; Возраст: %d\n", employees[i].getFullName(), employees[i].getAge());

        System.out.println("Task #5");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getAge() > 40)
                System.out.printf("ФИО: %s; Возраст: %d; Заработная плата: %d\n",
                    employees[i].getFullName(), employees[i].getAge(), employees[i].getSalary());
        }

        System.out.println("Task #6");
        System.out.println("Before: ");
        for (int i = 0; i < employees.length; i++) {
            System.out.printf("ФИО: %s; Возраст: %d; Заработная плата: %d\n",
                employees[i].getFullName(), employees[i].getAge(), employees[i].getSalary());
            raiseSalary(employees[i]);
        }
        System.out.println("After: ");
        for (int i = 0; i < employees.length; i++) {
            System.out.printf("ФИО: %s; Возраст: %d; Заработная плата: %d\n",
                    employees[i].getFullName(), employees[i].getAge(), employees[i].getSalary());
        }

        System.out.println("Task #7");
        float averageSalary = 0;
        float averageAge = 0;
        for (int i = 0; i < employees.length; i++) {
            averageAge += employees[i].getAge();
            averageSalary += employees[i].getSalary();
        }
        averageAge = averageAge * 1f / employees.length;
        averageSalary = averageSalary * 1f / employees.length;
        System.out.printf("Средний возраст: %4.1f; Средняя заработная плата: %7.2f", averageAge, averageSalary);
    }


    /**
     * Метод повышающий заработную плату сотрудникам старше 45 лет
     * @param emp Экземпляр класса Employee
     */
    private static void raiseSalary(Employee emp) {
        if (emp.getAge() > 45)
            emp.setSalary(emp.getSalary() + 5000);
    }
}
