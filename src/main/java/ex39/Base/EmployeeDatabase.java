package ex39.Base;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
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

    public List<Employee> sortDatabase(SortingType sortingType) {
        List<Employee> employees = new ArrayList<>();

        switch (sortingType){
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


}
