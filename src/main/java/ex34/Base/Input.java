/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex34.Base;

import java.text.DecimalFormat;
import java.util.Scanner;

public final class Input {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String NUMBER_FORMAT_EXCEPTION_MSG = "Only Numeric values are allowed.\n";
    private Input(){}

    public static double readDoubleRoundedToTwoDecimalPlaces() {
        return Double.parseDouble(new DecimalFormat("#.##")
                .format(Double.parseDouble(scanner.nextLine())));
    }

    public static double readDouble()
            throws NumberFormatException {
        try {
            return Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException nfe) {
            throw new NumberFormatException(NUMBER_FORMAT_EXCEPTION_MSG);
        }
    }

    public static int readInteger()
            throws NumberFormatException {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException nfe) {
            throw new NumberFormatException(NUMBER_FORMAT_EXCEPTION_MSG);
        }
    }

    public static String readString() { return scanner.nextLine();}
}
