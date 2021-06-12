/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex36.Base;

import java.util.Scanner;

public final class Input {
    private final static Scanner scanner = new Scanner(System.in);
    private Input() {}

    public static String readString() {
        return scanner.nextLine();
    }

    public static double readDouble()
            throws NumberFormatException {
        return Double.parseDouble(scanner.nextLine());
    }
}
