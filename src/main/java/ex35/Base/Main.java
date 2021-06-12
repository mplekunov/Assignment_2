/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex35.Base;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Contestant winner = Contest.drawWinner(readContestants());

        System.out.print("The winner is... " + (winner == null ? "no one...\nThere are no contestants" : winner.getName()));
    }

    public static ContestDatabase readContestants() {
        ArrayList<Contestant> contestants = new ArrayList<>();

        while (true) {
            System.out.print("Enter a name: ");

            Contestant contestant = readInput();

            if(contestant != null)
                contestants.add(contestant);
            else
                break;
        }

        return new ContestDatabase(contestants);
    }

    public static Contestant readInput() {
        String name = Input.readString();
        return name.isEmpty() ? null : new Contestant(name);
    }
}
