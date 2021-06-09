/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex28.Base;

import java.io.InputStream;

public final class TotalCalculator {
    private static final InputStream inputStream = System.in;
    private TotalCalculator(){ }

    public static double calculateTotal(int numQuantity, String promptToUser) {
        double total = 0;
        for (int i = 0; i < numQuantity; i++) {
            System.out.print(promptToUser);
            try {
                total += Input.readDouble(inputStream);
            } catch (NumberFormatException nfe) {
                //ignore silently
            }
        }

        return total;
    }
}
