/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex28.Base;

import java.text.DecimalFormat;
import java.util.Scanner;

public final class Input {
    private final static Scanner scanner = new Scanner(System.in);
    private Input(){}

    public static double readDoubleRoundedToTwoDecimalPlaces() {
        return Double.parseDouble(new DecimalFormat("#.##")
                .format(Double.parseDouble(scanner.nextLine())));
    }

    public static double readDouble() throws NumberFormatException {
        return Double.parseDouble(scanner.nextLine());
    }

    public static int readInteger() {return Integer.parseInt(scanner.nextLine());}
}
