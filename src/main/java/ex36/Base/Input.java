/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex36.Base;

import java.io.InputStream;
import java.util.Scanner;

public final class Input {
    private Input() {}

    public static String readString(InputStream inputStream) {
        return new Scanner(inputStream).nextLine();
    }

    public static double readDouble(String num)
            throws NumberFormatException {
        return Double.parseDouble(num);
    }

    public static double readDouble(InputStream inputStream)
            throws NumberFormatException {
        return readDouble(new Scanner(inputStream).nextLine());
    }
}
