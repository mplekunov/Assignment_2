/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex32.Base;

public class Main {
    public static void main(String[] args) {
        do {

            System.out.println("Let's play Guess the Number!");

            int difficultyLevel;

            while (true) {
                System.out.print("Enter the difficulty level (1, 2, or 3): ");

                try {
                    difficultyLevel = Input.readInteger();
                } catch (NumberFormatException nfe) {
                    System.out.print(nfe.getMessage());
                    continue;
                }
                break;
            }

            NumberGuesser numberGuesser = new NumberGuesser(difficultyLevel);

            numberGuesser.startGame();

            System.out.print("Do you wish to play again (Y/N)? ");

        } while (!Input.readString().equalsIgnoreCase("n"));
    }
}
