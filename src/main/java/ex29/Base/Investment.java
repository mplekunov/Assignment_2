/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex29.Base;

public final class Investment {
    private Investment() {}

    public static double calculateTimeRequiredForDoublingInvestment(double rateOfReturn)
            throws ArithmeticException {
        try {
            return rateOfReturn == 0 ? 72 / (int)rateOfReturn : 72 / rateOfReturn;
        } catch (ArithmeticException e ) {
            throw new ArithmeticException("Division by zero is prohibited.\n");
        }
    }
}
