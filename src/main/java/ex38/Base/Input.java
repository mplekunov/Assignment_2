package ex38.Base;

import java.io.InputStream;
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
