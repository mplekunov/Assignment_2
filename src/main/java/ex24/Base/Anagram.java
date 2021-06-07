package ex24.Base;

import java.util.Arrays;
import java.util.Locale;

public class Anagram {
    private char[] firstString;
    private char[] secondString;

    public Anagram(String firstString, String secondString) {
        this.firstString = firstString.toLowerCase(Locale.ROOT).toCharArray();
        this.secondString = secondString.toLowerCase(Locale.ROOT).toCharArray();
    }
    public boolean isAnagram() {
        if (firstString.length != secondString.length)
            return false;

        Arrays.sort(firstString);
        Arrays.sort(secondString);

        return Arrays.equals(firstString, secondString);
    }

    public char[] getFirstString() {
        return firstString;
    }

    public char[] getSecondString() {
        return secondString;
    }
}
