/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex35.Base;

import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

public final class Input {
    private final static Scanner scanner = new Scanner(System.in);
    private Input() {}

    public static String readString()
            throws NoSuchElementException {
        return scanner.nextLine();
    }
}
