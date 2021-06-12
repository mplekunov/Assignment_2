/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex34.Base;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EmployeeDatabaseTest {
    private final EmployeeDatabase employeeDatabase;

    public EmployeeDatabaseTest() {
        ArrayList<Employee> employeeCollection = new ArrayList<>();
        employeeCollection.add(new Employee("John", "Smith"));
        employeeCollection.add(new Employee("Jackie", "Jackson"));
        employeeCollection.add(new Employee("Chris" ,"Jones"));
        employeeCollection.add(new Employee("Amanda", "Cullen"));
        employeeCollection.add(new Employee("Jeremy", "Goodwin"));

        employeeDatabase = new EmployeeDatabase(employeeCollection);
    }

    @ParameterizedTest
    @MethodSource("testEmployees")
    @DisplayName("Employee can be found in the database")
    void findAnEmployee(Employee employee) {
        Exception exception = null;
        try {
            employeeDatabase.findAnEmployee(employee);
        } catch (NoSuchElementException nse) {
            exception = nse;
        }

        assertNull(exception);
    }

    @ParameterizedTest
    @MethodSource("testEmployees")
    @DisplayName("Employee can be removed from the database")
    void removeEmployee(Employee employee) {
        assertTrue(employeeDatabase.removeEmployee(employee));
    }

    static Stream<Employee> testEmployees() {
        return Stream.of(new Employee("John", "Smith"), new Employee("Jackie", "Jackson"), new Employee("Chris" ,"Jones"));
    }
}