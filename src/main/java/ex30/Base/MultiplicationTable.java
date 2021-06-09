/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex30.Base;

public final class MultiplicationTable {
    private MultiplicationTable() {}

    public static void printTable(int from, int to) {
        for (int i = from; i <= to; i++) {
            for (int j = from; j <= to; j++ ) {
                System.out.printf("%5d", i * j);
            }
            System.out.print("\n");
        }
    }
}
