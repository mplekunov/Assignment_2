/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex24.Base;

import java.util.Arrays;

public class Anagram {
    private final char[] firstString;
    private final char[] secondString;

    public Anagram(String firstString, String secondString) {
        this.firstString = firstString.toLowerCase().toCharArray();
        this.secondString = secondString.toLowerCase().toCharArray();
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
