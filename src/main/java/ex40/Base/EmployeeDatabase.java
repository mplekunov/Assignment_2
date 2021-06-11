package ex40.Base;

import java.time.LocalDate;
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

    public List<Employee> findByLastName(String name) {
        return employees.stream()
                .filter(o -> o.getLastName().contains(name))
                .collect(Collectors.toList());
    }

    public List<Employee> findByPosition(String position) {
        return employees.stream()
                .filter(o -> o.getPosition().contains(position))
                .collect(Collectors.toList());
    }

    public List<Employee> findByDate() {
        LocalDate now = LocalDate.now().minusMonths(6);

        return employees.stream()
                .filter(o -> o.getSeparationDate() != null && (now.isAfter(o.getSeparationDate()) || now.isEqual(o.getSeparationDate())))
                .collect(Collectors.toList());
    }


}
