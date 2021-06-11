/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex28.Base;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        double total = TotalCalculator.calculateTotal(fillNumberCollection(System.in));

        System.out.print("The total is " + (total == (long)total ? String.format("%d", (long)total) : String.format("%s", total)));
    }

    public static List<Double> fillNumberCollection(InputStream inputStream) {
        List<Double> numbers = new ArrayList<>();

        System.out.print("Enter how many numbers you want to add: ");
        int numberQty = Input.readInteger(inputStream);

        for (int i = 0; i < numberQty; i++) {
            System.out.print("Enter a number: ");
            numbers.add(readInput(inputStream));
        }

        return numbers;
    }

    public static Double readInput(InputStream inputStream) {
        try {
            return (Input.readDouble(inputStream));
        } catch (NumberFormatException nfe) {
            //ignore silently
        }
        return null;
    }
}
