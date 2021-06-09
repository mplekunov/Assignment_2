/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex27.Base;

import org.javatuples.Pair;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while(true) {
            String firstName = readInput("Enter the first name: ");
            String lastName = readInput("Enter the last name: ");
            String zipCode = readInput("Enter the ZIP code: ");
            String id = readInput("Enter an Employee ID: ");

            Validation validation = new Validation(firstName, lastName, zipCode, id);
            Pair<String, InputFlags> resultPair = validation.validateInput();

            System.out.print(resultPair.getValue0());

            if (resultPair.contains(InputFlags.CORRECT_FORMAT))
                break;
        }
    }

    public static String readInput(String promptToUser) {
        System.out.print(promptToUser);
        return new Scanner(System.in).nextLine();
    }
}
