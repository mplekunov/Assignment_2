/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex29.Base;

import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.Scanner;

public final class Input {
    private Input(){}

    public static double readDoubleRoundedToTwoDecimalPlaces(InputStream inputStream) {
        return Double.parseDouble(new DecimalFormat("#.##")
                .format(Double.parseDouble(new Scanner(inputStream).nextLine())));
    }

    public static double readDouble(InputStream inputStream)
            throws NumberFormatException {
        try {
            return Double.parseDouble(new Scanner(inputStream).nextLine());
        } catch (NumberFormatException nfe) {
            throw new NumberFormatException("Only Numeric values are allowed.\n");
        }
    }

    public static int readInteger(InputStream inputStream) {return Integer.parseInt(new Scanner(inputStream).nextLine());}
}
