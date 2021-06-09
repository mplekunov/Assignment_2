/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex31.Base;

public class Main {
    public static void main(String[] args) {
        int age = readInput("Enter your age: ");
        int restingHR = readInput("Enter your resting heart rate: ");

        KarvonenCalculator karvonenCalculator = new KarvonenCalculator(age, restingHR);
        karvonenCalculator.printHeartRateTable(55, 95, 5);
    }

    public static int readInput(String promptToUser) {
        int num;

        while (true) {
            try {
                System.out.print(promptToUser);
                num = Input.readInteger(System.in);
            } catch (NumberFormatException nfe) {
                System.out.print(nfe.getMessage());
                continue;
            }
            break;
        }

        return num;
    }
}
