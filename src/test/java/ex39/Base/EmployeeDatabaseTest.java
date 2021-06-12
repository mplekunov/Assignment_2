package ex39.Base;

import org.hamcrest.collection.IsIterableContainingInRelativeOrder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.hamcrest.collection.IsIterableContainingInOrder;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeDatabaseTest {
    private final ArrayList<HashMap<Type, String>> employees = new ArrayList<>();

    public EmployeeDatabaseTest() {
        employees.add(Employee.convertToMap("John", "Johnson", 	"Manager", "2016-12-31"));
        employees.add(Employee.convertToMap("Tou", "Xiong", 	"Software Engineer", "2016-10-05"));
        employees.add(Employee.convertToMap("Michaela", "Michaelson", 	"District Manager","2015-12-19"));
        employees.add(Employee.convertToMap("Jake", "Jacobson", 	"Programmer",""));
        employees.add(Employee.convertToMap("Jacquelyn", "Jackson", 	"DBA", ""));
        employees.add(Employee.convertToMap("Sally", "Webber", 	"Web Developer","2015-12-18"));
    }

    @Test
    @DisplayName("Sorting by last name works")
    void sortBy_Last_Name() {
        EmployeeDatabase database = new EmployeeDatabase(employees);
        List<HashMap<Type, String>> actual = database.sortBy(Type.LAST_NAME);
        List<HashMap<Type, String>> expected = new ArrayList<>();

        expected.add(Employee.convertToMap("Jacquelyn", "Jackson", 	"DBA", ""));
        expected.add(Employee.convertToMap("Jake", "Jacobson", 	"Programmer",""));
        expected.add(Employee.convertToMap("John", "Johnson", 	"Manager", "2016-12-31"));
        expected.add(Employee.convertToMap("Michaela", "Michaelson", 	"District Manager","2015-12-19"));
        expected.add(Employee.convertToMap("Sally", "Webber", 	"Web Developer","2015-12-18"));
        expected.add(Employee.convertToMap("Tou", "Xiong", 	"Software Engineer", "2016-10-05"));

        assertEquals(expected, actual);
    }
}