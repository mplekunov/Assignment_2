package ex39.Base;

import java.io.InputStream;
import java.util.Scanner;

public final class Input {
    private static final Scanner scanner = new Scanner(System.in);
    private Input() {}

    public static String readString() {
        return scanner.nextLine();
    }
}
