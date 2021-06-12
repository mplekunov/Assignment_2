/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex25.Base;

import java.util.Scanner;

public class Input {
    private final static Scanner scanner = new Scanner(System.in);
    private Input() {}

    public static String readString() {
        return scanner.nextLine();
    }
}
