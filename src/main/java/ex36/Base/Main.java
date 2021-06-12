/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex36.Base;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ArrayList<Double> numbers = fillArrayWithUserInput();

        printOutput(new Statistics(numbers));
    }

    public static ArrayList<Double> fillArrayWithUserInput() {
        ArrayList<Double> numbers = new ArrayList<>();

        while (true) {
            Double input = readInput();

            if (input != null)
                numbers.add(input);
            else
                break;
        }

        return numbers;
    }

    public static void printOutput(Statistics statistics) {
        DecimalFormat df = new DecimalFormat("#.##");

        String output = statistics.getNumbers().stream().map(df::format)
                .collect(Collectors.joining(", "));

        System.out.print("Numbers: " + output
                .concat("\nThe average is ").concat(df.format(statistics.getAverage()))
                .concat("\nThe minimum is ").concat(df.format(statistics.getMin()))
                .concat("\nThe maximum is ").concat(df.format(statistics.getMax()))
                .concat("\nThe standard deviation is ").concat(df.format(statistics.getStandardDeviation())));
    }

    public static Double readInput() {
        String input;

        while (true) {
            System.out.print("Enter a number: ");
            input = Input.readString();

            if (input.equalsIgnoreCase("done"))
                return null;
            else {
                try {
                    return Input.readDouble();
                } catch (NumberFormatException nfe) {
                    System.out.println("Non numeric values are prohibited!");
                }
            }
        }
    }
}
