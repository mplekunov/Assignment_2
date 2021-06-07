/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex24.Base;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter two strings and I'll tell you if they are anagrams:");

        String firstStr = readInput("Enter the first string: ");
        String secondStr = readInput("Enter the second string: ");

        processAndOutput(new Anagram(firstStr, secondStr));
    }

    public static String readInput(String promptToUser) {
        System.out.println(promptToUser);
        return new Scanner(System.in).nextLine();
    }

    public static void processAndOutput(Anagram anagram) {
        String output =  ("\"").concat(Arrays.toString(anagram.getFirstString()))
                .concat("\" and \"").concat(Arrays.toString(anagram.getSecondString())).concat("\"");

        System.out.print(anagram.isAnagram() ?
                output.concat(" are anagrams.") : output.concat(" aren't anagrams."));
    }
}
