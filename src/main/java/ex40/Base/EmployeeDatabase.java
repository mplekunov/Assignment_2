package ex40.Base;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EmployeeDatabase {
    private final ArrayList<Employee> employees;

    public EmployeeDatabase() {
        employees = new ArrayList<>();
    }

    public EmployeeDatabase(List<Employee> employees) {
        this();
        this.employees.addAll(employees);
    }

    public List<Employee> sortDatabase(Type type) {
        List<Employee> employees = new ArrayList<>();

        switch (type){
            case LAST_NAME -> employees = sortByLastName();
//            case POSITION -> sortByPosition();
//            case SEPARATION_DATE -> sortBySeparationDate();
        }

        return employees;
    }

//    private List<Employee> sortByPosition() {
//    }

    private List<Employee> sortByLastName() {
        return employees.stream().sorted(Comparator.comparing(Employee::getLastName)).collect(Collectors.toList());
    }

//    private List<Employee> sortBySeparationDate() {
//
//    }

    private Map<String, Employee> toMap(Type type) {
        return switch (type) {
            case LAST_NAME -> employees.stream().collect(Collectors.toMap(Employee::getLastName, Function.identity()));

            case FIRST_NAME -> employees.stream().collect(Collectors.toMap(Employee::getFirstName, Function.identity()));

            case POSITION -> employees.stream().collect(Collectors.toMap(Employee::getPosition, Function.identity()));

            default -> throw new IllegalStateException("Unexpected value: " + type);
        };
    }

    private Map<LocalDate, Employee> toMapLocalDate() {
        return employees.stream().collect(Collectors.toMap(Employee::getSeparationDate, Function.identity(),
                (address1, address2) -> address1));
        //I have multiple values with NULL Key, therefore Duplicate Key exception may occur
        //Merge Function fixes the issue
    }


    public List<Employee> findByLastName(String name) {
        return toMap(Type.LAST_NAME).entrySet().stream()
                .filter(o -> o.getKey().contains(name))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public List<Employee> findByPosition(String position) {
        return toMap(Type.POSITION).entrySet().stream()
                .filter(o -> o.getKey().contains(position))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public List<Employee> findByDate() {
        LocalDate now = LocalDate.now().minusMonths(6);

        return toMapLocalDate().entrySet().stream()
                .filter(o -> o.getKey() != null && (now.isAfter(o.getKey()) || now.isEqual(o.getKey())))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }


}
