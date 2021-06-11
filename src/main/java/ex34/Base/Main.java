/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex34.Base;

import java.util.HashSet;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        HashSet<Employee> employees = new HashSet<>();
        employees.add(new Employee("John", "Smith"));
        employees.add(new Employee("Jackie", "Jackson"));
        employees.add(new Employee("Chris" ,"Jones"));
        employees.add(new Employee("Amanda", "Cullen"));
        employees.add(new Employee("Jeremy", "Goodwin"));

        EmployeeDatabase database = new EmployeeDatabase(employees);
        Employee employee;

        printDatabase(database);

        while (true) {
            try {
                employee = database.findAnEmployee(readInput());
            } catch (NoSuchElementException | IndexOutOfBoundsException e) {
                if (e.getClass().equals(NoSuchElementException.class))
                    System.out.print("There is no employee with such name.");
                else
                    System.out.print("Enter First Name and Last Name of employee (e.g. Prince Henry).");
                continue;
            }
            break;
        }

        database.removeEmployee(employee);

        printDatabase(database);
    }

    public static Employee readInput()
            throws IndexOutOfBoundsException {
        System.out.print("\nEnter an employee name to remove: ");
        String input = Input.readString();

        return new Employee(input.substring(0, input.indexOf(" ")), input.substring(input.indexOf(" ") + 1));
    }

    public static void printDatabase(EmployeeDatabase database) {
        System.out.printf("\nThere are %d employees:\n", database.getNumOfEmployees());
        database.getEmployees().forEach(o -> System.out.println(o.getFirstName().concat(" ").concat(o.getLastName())));
    }
}
