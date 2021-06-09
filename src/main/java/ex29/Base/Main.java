/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex29.Base;

public class Main {
    public static void main(String[] args) {

        while (true) {
            System.out.print("What is the rate of return? ");
            double rateOfReturn, result;

            try {
                rateOfReturn =  Input.readDouble(System.in);
                result = Investment.calculateTimeRequiredForDoublingInvestment(rateOfReturn);
            } catch (NumberFormatException | ArithmeticException e)
            {
                System.out.print(e.getMessage());
                continue;
            }

            System.out.print("It will take " + (result == (long) result ? String.format("%d", (long) result) : String.format("%s", result))
                        + " years to double your initial investment");
            break;
        }
    }
}
