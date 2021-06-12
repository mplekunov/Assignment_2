/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex39.Base;

import java.util.HashMap;

public final class Employee {
    private Employee() {}

    public static HashMap<Type, String> convertToMap(String firstName, String lastName, String position, String separationDate) {
        HashMap<Type, String> employee = new HashMap<>();

        employee.put(Type.FIRST_NAME, firstName);
        employee.put(Type.LAST_NAME, lastName);
        employee.put(Type.POSITION, position);
        employee.put(Type.SEPARATION_DATE, separationDate);

        return employee;
    }
}
