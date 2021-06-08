/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex26.Base;

public class Main {
    public static void main(String[] args) {
        double balance = readInput("What is your balance? ", true);
        int APR = readInput("What is the APR on the card (as a percent)? ");
        double montlyPayment = readInput("What is the monthly payment you can make? ", true);

        printOutput(PaymentCalculator.calculateMonthsUntilPaidOff(balance, APR, montlyPayment));

    }

    public static double readInput(String promptToUser, boolean isRound) {
        System.out.print(promptToUser);
        return isRound ? Input.readDoubleRoundedToTwoDecimalPlaces() : Input.readDouble();
    }

    public static int readInput(String promptToUser) {
        System.out.print(promptToUser);
        return Input.readInteger();
    }

    public static void printOutput(int numOfMonths) {
        System.out.print("It will take you " + numOfMonths + " to pay off this card.");
    }

}
