package ex39.Base;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee {
    private String firstName;
    private String lastName;
    private String position;
    private Date separationDate;

    public Employee(String firstName, String lastName, String position, Date separationDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.separationDate = separationDate;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public Date getSeparationDate() {
        return separationDate;
    }

    public String getPosition() {
        return position;
    }
}
