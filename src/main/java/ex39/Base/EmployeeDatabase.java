/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex39.Base;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class EmployeeDatabase {
    private final ArrayList<HashMap<Type, String>> employees;

    public EmployeeDatabase() {
        employees = new ArrayList<>();
    }

    public EmployeeDatabase(List<HashMap<Type, String>> employees) {
        this();
        this.employees.addAll(employees);
    }

    public List<HashMap<Type, String>> sortBy(Type type) {
        return employees.stream()
                .sorted(Comparator.comparing(o -> o.get(type)))
                .collect(Collectors.toList());
    }

    public List<HashMap<Type, String>> findBy(Type type, String input) {
        if (type.equals(Type.SEPARATION_DATE))
            return findByDate(input);
        else
            return employees.stream()
                .filter(o -> o.get(type).toLowerCase(Locale.ROOT).contains(input.toLowerCase(Locale.ROOT)))
                .collect(Collectors.toList());
    }

    private List<HashMap<Type, String>> findByDate(String input) {
        LocalDate now = LocalDate.now().minusMonths(Integer.parseInt(input));

        return employees.stream()
                .filter(o -> {
                    LocalDate oDate = Converter.convertStringToDate(o.get(Type.SEPARATION_DATE), "yyyy-MM-dd");
                    return oDate != null && (now.isAfter(oDate) || now.isEqual(oDate));
                }).collect(Collectors.toList());
    }


}
