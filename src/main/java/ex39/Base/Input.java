package ex39.Base;

import java.io.InputStream;
import java.util.Scanner;

public final class Input {
    private Input() {}

    public static String readString(InputStream inputStream) {
        return new Scanner(inputStream).nextLine();
    }
}
