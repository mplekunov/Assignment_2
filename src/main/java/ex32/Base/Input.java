/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex32.Base;

import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.Scanner;

public final class Input {
    private static final String NUMBER_FORMAT_EXCEPTION_MSG = "Only Numeric values are allowed.\n";
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
            throw new NumberFormatException(NUMBER_FORMAT_EXCEPTION_MSG);
        }
    }

    public static int readInteger(InputStream inputStream)
            throws NumberFormatException {
        try {
            return Integer.parseInt(new Scanner(inputStream).nextLine());
        } catch (NumberFormatException nfe) {
            throw new NumberFormatException(NUMBER_FORMAT_EXCEPTION_MSG);
        }
    }

    public static String readString(InputStream inputStream) { return new Scanner(inputStream).nextLine();}
}
