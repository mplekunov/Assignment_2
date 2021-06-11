package ex40.Base;

import java.time.LocalDate;

public class Employee {
    private String firstName;
    private String lastName;
    private String position;
    private LocalDate separationDate;

    public Employee(String firstName, String lastName, String position, LocalDate separationDate) {
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

    public LocalDate getSeparationDate() {
        return separationDate;
    }

    public String getPosition() {
        return position;
    }
}
