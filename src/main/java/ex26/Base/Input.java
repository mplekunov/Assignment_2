/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex26.Base;

import java.text.DecimalFormat;
import java.util.Scanner;

public final class Input {
    private static final Scanner in = new Scanner(System.in);
    private Input(){}

    public static double readDoubleRoundedToTwoDecimalPlaces() {
        return Double.parseDouble(new DecimalFormat("#.##").format(Double.parseDouble(in.nextLine())));
    }

    public static double readDouble() {
        return Double.parseDouble(in.nextLine());
    }

    public static int readInteger() {return Integer.parseInt(in.nextLine());}
}
