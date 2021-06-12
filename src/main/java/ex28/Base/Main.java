/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex28.Base;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        double total = TotalCalculator.calculateTotal(fillNumberCollection());

        System.out.print("The total is " + (total == (long)total ? String.format("%d", (long)total) : String.format("%s", total)));
    }

    public static List<Double> fillNumberCollection() {
        List<Double> numbers = new ArrayList<>();
        int numberQty;

        System.out.print("Enter how many numbers you want to add: ");

        while(true) {
            try {
                numberQty = (int)Input.readDouble();
            } catch (NumberFormatException nfe) {
                System.out.println("Only numeric values are allowed!");
                continue;
            }
            break;
        }

        for (int i = 0; i < numberQty; i++) {
            System.out.print("Enter a number: ");
            double number;

            try {
                number = Input.readDouble();
            } catch (NumberFormatException nfe) {
                //ignore silently
                continue;
            }

            numbers.add(number);
        }

        return numbers;
    }
}
