package ex39.Base;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John", "Johnson", 	"Manager", Converter.convertStringToDate("2016-12-31", "yyyy-MM-dd")));
        employees.add(new Employee("Tou", "Xiong", 	"Software Engineer", Converter.convertStringToDate("2016-10-05", "yyyy-MM-dd")));
        employees.add(new Employee("Michaela", "Michaelson", 	"District Manager", Converter.convertStringToDate("2015-12-19", "yyyy-MM-dd")));
        employees.add(new Employee("Jake", "Jacobson", 	"Programmer", Converter.convertStringToDate("", "yyyy-MM-dd")));
        employees.add(new Employee("Jacquelyn", "Jackson", 	"DBA", Converter.convertStringToDate("", "yyyy-MM-dd")));
        employees.add(new Employee("Sally", "Webber", 	"Web Developer", Converter.convertStringToDate("2015-12-18", "yyyy-MM-dd")));

        EmployeeDatabase database = new EmployeeDatabase(employees);

        printOutput(database.sortDatabase(SortingType.LAST_NAME));
    }


    public static void printOutput(List<Employee> employees) {
        var wrapper = new Object(){String output = "";};
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        employees.forEach(o -> wrapper.output = wrapper.output.concat(o.getFirstName()).concat(" ").concat(o.getLastName())
                .concat(getWhitespaces(19 - (o.getFirstName().length() + o.getLastName().length()))).concat("|")
                .concat(o.getPosition()).concat(getWhitespaces(19 - o.getPosition().length())).concat("|")
                        .concat(o.getSeparationDate() != null ? sdf.format(o.getSeparationDate()) : "")
                        .concat(getWhitespaces(20 - (o.getSeparationDate() != null ? o.getSeparationDate().toString().length() : 0)))
                        .concat("\n"));

        System.out.println("Name                |Position           |Separation Date\n" +
                "--------------------|-------------------|----------------\n" + wrapper.output);
    }

    private static String getWhitespaces(int length) {
        String output = "";
        for (int i = 0; i < length; i++)
            output = output.concat(" ");
        return  output;
    }
}
