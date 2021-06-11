package ex39.Base;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Formatter;
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

        employees.forEach(o -> {
            String spacesName = getWhitespaces(19 -(o.getFirstName().length() + o.getLastName().length()));

            String spacesPosition = getWhitespaces(19 - (o.getPosition().length()));

            String spacesSeparationDate = getWhitespaces(19 -
                    (o.getSeparationDate() != null ? sdf.format(o.getSeparationDate()).length() : 0));

            wrapper.output = wrapper.output.concat(String.format("%s %s%s|%s%s|%s%s\n",
                    o.getFirstName(), o.getLastName(),spacesName,
                    o.getPosition(), spacesPosition,
                    o.getSeparationDate() != null ? sdf.format(o.getSeparationDate()) : "", spacesSeparationDate));
        });

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
