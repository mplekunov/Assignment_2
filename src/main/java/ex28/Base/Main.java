/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex28.Base;

public class Main {
    public static void main(String[] args) {
        System.out.print("Enter how many numbers you want to add: ");
        int numberQty = Input.readInteger(System.in);

        double total = TotalCalculator.calculateTotal(numberQty, "Enter a number: ");

        System.out.print("The total is " + (total == (long)total ? String.format("%d", (long)total) : String.format("%s", total)));
    }
}
