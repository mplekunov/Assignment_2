/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex34.Base;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class EmployeeDatabase {
    private ArrayList<Employee> employees;
    private int numOfEmployees;

    private EmployeeDatabase() {
        this.employees = new ArrayList<>();
        this.numOfEmployees = 0;
    }

    public EmployeeDatabase(ArrayList<Employee> employees) {
        this();
        this.employees.addAll(employees);
        this.numOfEmployees = this.employees.size();
    }

    public EmployeeDatabase(Employee employee) {
        this();
        employees.add(employee);
        this.numOfEmployees = this.employees.size();
    }

    public Employee findAnEmployee(Employee employee)
            throws NoSuchElementException{
       return employees.stream().filter(o -> o.getLastName().equals(employee.getLastName())
                && o.getFirstName().equals(employee.getFirstName())).findFirst().orElseThrow();
    }

    public boolean removeEmployee(Employee employee) {
        boolean operationResult = employees.remove(findAnEmployee(employee));
        numOfEmployees = employees.size();
        return operationResult;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public int getNumOfEmployees()
    {
        return numOfEmployees;
    }
}
