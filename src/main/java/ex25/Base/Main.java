/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex25.Base;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String password = readInput("Enter password that you would like to validate: ");



    }

    public static String readInput(String promptToUser) {
        System.out.print(promptToUser);
        return new Scanner(System.in).nextLine();
    }

    public static void output(Password password) {
        String output = "The password " + password.getPassword().concat(" is a ");

        switch (password.getStrength()) {
            case VERY_WEAK -> output = output.concat("very weak password.");
            case WEAK -> output = output.concat("weak password.");
            case STRONG -> output = output.concat("strong password.");
            case VERY_STRONG -> output = output.concat("very strong password.");
        }

        System.out.print(output);
    }
}
