/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex25.Base;

public class Main {
    public static void main(String[] args) {
        String password = readInput("Enter password that you would like to validate: ");

        output(password);
    }

    public static String readInput(String promptToUser) {
        System.out.print(promptToUser);
        return Input.readString();
    }

    public static void output(String password) {
        String output = "The password " + password.concat(" is a ");

        switch (PasswordStrengthDetector.passwordValidator(password)) {
            case VERY_WEAK -> output = output.concat("very weak password.");
            case WEAK -> output = output.concat("weak password.");
            case STRONG -> output = output.concat("strong password.");
            case VERY_STRONG -> output = output.concat("very strong password.");
        }

        System.out.print(output);
    }
}
