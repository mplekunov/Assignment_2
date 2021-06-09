/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex33.Base;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("What's your question?\n> ");
        new Scanner(System.in).nextLine();//We don't care about question

        System.out.print(MagicBall.getAnswer());
    }
}
