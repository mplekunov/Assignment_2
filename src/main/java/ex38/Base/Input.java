package ex38.Base;

import java.io.InputStream;
import java.util.Scanner;

public final class Input {
    private Input() {}

    public static String readString(InputStream inputStream) {
        return new Scanner(inputStream).nextLine();
    }

    public static double readDouble(String input)
            throws NumberFormatException {
        return Double.parseDouble(input);
    }

    public static double readDouble(InputStream inputStream)
            throws NumberFormatException {
        return readDouble(readString(inputStream));
    }
}
