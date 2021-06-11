package ex37.Base;

import java.io.InputStream;
import java.util.Scanner;

public final class Input {
    private Input() {}

    public static String readString(InputStream inputStream) {
        return new Scanner(inputStream).nextLine();
    }

    public static int readInteger(String input)
            throws NumberFormatException {
        return Integer.parseInt(input);
    }

    public static int readInteger(InputStream inputStream)
            throws NumberFormatException {
        return readInteger(readString(inputStream));
    }
}
