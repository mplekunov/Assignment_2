/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex26.Base;

public final class PaymentCalculator {
    private PaymentCalculator() {}

    public static int calculateMonthsUntilPaidOff(double balance, int APR, double monthlyPayment) {
        return (int)Math.ceil(-(1/30.0) *
                Math.log(1 + balance/monthlyPayment * (1 - Math.pow(1 + (APR / 100.0) / 365.0, 30)))
                / Math.log(1 + (APR / 100.0) / 365.0));
    }
}
