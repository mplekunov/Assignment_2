package ex39.Base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<HashMap<Type, String>> employees = new ArrayList<>();

        employees.add(Employee.convertToMap("John", "Johnson", 	"Manager", "2016-12-31"));
        employees.add(Employee.convertToMap("Tou", "Xiong", 	"Software Engineer", "2016-10-05"));
        employees.add(Employee.convertToMap("Michaela", "Michaelson", 	"District Manager","2015-12-19"));
        employees.add(Employee.convertToMap("Jake", "Jacobson", 	"Programmer",""));
        employees.add(Employee.convertToMap("Jacquelyn", "Jackson", 	"DBA", ""));
        employees.add(Employee.convertToMap("Sally", "Webber", 	"Web Developer","2015-12-18"));

        EmployeeDatabase database = new EmployeeDatabase(employees);

        printOutput(database.sortBy(Type.LAST_NAME));
    }

    public static void printOutput(List<HashMap<Type, String>> employees) {
        var wrapper = new Object(){String output = "";};

        employees.forEach(o -> {
            wrapper.output = wrapper.output.concat(String.format("%-20s|%-20s|%-20s\n",
                    o.get(Type.FIRST_NAME).concat(" ").concat(o.get(Type.LAST_NAME)),
                    o.get(Type.POSITION),
                    o.get(Type.SEPARATION_DATE)));
        });

        System.out.println("Name                |Position            |Separation Date\n" +
                           "--------------------|--------------------|--------------------\n" + wrapper.output);
    }
}
