/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex39.Base;

import java.util.Scanner;

public final class Input {
    private static final Scanner scanner = new Scanner(System.in);
    private Input() {}

    public static String readString() {
        return scanner.nextLine();
    }
}
