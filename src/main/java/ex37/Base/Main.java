/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex37.Base;

public class Main {
    public static void main(String[] args) {
        int minLength = readInput("What is the minimum length? ");
        int numSpecialChar = readInput("How many special characters? ");
        int numNumbers = readInput("How many numbers? ");

        PasswordGenerator pg = new PasswordGenerator(numNumbers, numSpecialChar, minLength);

        printOutput(pg.generatePassword());
    }

    public static int readInput(String promptToUser) {
        int number;

        while (true) {
            System.out.print(promptToUser);

            try {
                number = Input.readInteger(System.in);
            } catch (NumberFormatException nfe) {
                System.out.println("Only numeric values are allowed!");
                continue;
            }

            break;
        }

        return number;
    }

    public static void printOutput(Password password) {
        System.out.print("Your password is " + password.getPassword());
    }
}
