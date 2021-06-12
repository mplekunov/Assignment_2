/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex40.Base;

import ex39.Base.Employee;
import ex39.Base.EmployeeDatabase;
import ex39.Base.Type;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeDatabaseTest {
    private final ArrayList<HashMap<Type, String>> employees = new ArrayList<>();

    public EmployeeDatabaseTest() {
        employees.add(ex39.Base.Employee.convertToMap("John", "Johnson", 	"Manager", "2016-12-31"));
        employees.add(ex39.Base.Employee.convertToMap("Tou", "Xiong", 	"Software Engineer", "2016-10-05"));
        employees.add(ex39.Base.Employee.convertToMap("Michaela", "Michaelson", 	"District Manager","2015-12-19"));
        employees.add(ex39.Base.Employee.convertToMap("Jake", "Jacobson", 	"Programmer",""));
        employees.add(ex39.Base.Employee.convertToMap("Jacquelyn", "Jackson", 	"DBA", ""));
        employees.add(Employee.convertToMap("Sally", "Webber", 	"Web Developer","2015-12-18"));
    }

    @Test
    @DisplayName("Finding by last name works")
    void findBy_Last_Name() {
        EmployeeDatabase database = new EmployeeDatabase(employees);
        List<HashMap<ex39.Base.Type, String>> actual = database.findBy(ex39.Base.Type.LAST_NAME, "Jac");

        long actualSize = actual.stream().filter(o -> o.get(Type.LAST_NAME).contains("Jac")).count();

        assertEquals(actualSize, 2);
    }
}