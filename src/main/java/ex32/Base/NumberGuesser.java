/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex32.Base;

import ex31.Base.Input;
import java.util.HashSet;
import java.util.concurrent.ThreadLocalRandom;

public class NumberGuesser {
    private final DifficultyLevel difficultyLevel;
    private int guessCounter;

    public NumberGuesser(int difficultyLevel) {
        this.difficultyLevel = DifficultyLevel.fromInteger(difficultyLevel);
        this.guessCounter = 0;
    }

    public static int getRandomNumber(int minNum, int maxNum) {
        return ThreadLocalRandom.current().nextInt(1,maxNum + 1);
    }

    public void startGame() {
        HashSet<Integer> guesses = new HashSet<>();
        int maxNum = 0;

        switch (difficultyLevel) {
            case FIRST_EASIEST -> maxNum = 10;
            case SECOND_EASIEST -> maxNum = 100;
            case THIRD_EASIEST -> maxNum = 1000;
        }

        int randNum = getRandomNumber(1, maxNum);
        int guess = 0;

        System.out.print("I have my number. ");
        while (guess != randNum) {
            guessCounter++;

            if (guessCounter == 1)
                System.out.print("What's your guess? ");
            else
                System.out.print("Guess again: ");

            try {
                guess = Input.readInteger();
            } catch (NumberFormatException nfe) {
                System.out.println(nfe.getMessage().concat("Your answer counts as a wrong guess! "));
                continue;
            }

            if (!guesses.add(guess)) {
                System.out.print("You already guessed that number. Your answer counts as a wrong guess! ");
                continue;
            }

            if (guess < randNum)
                System.out.print("Too low. ");
            else if (guess > randNum)
                System.out.print("Too high. ");
            else
                System.out.println("You got it in " + guessCounter + " guesses!\n" + evaluateGuesses());
        }
    }

    private String evaluateGuesses() {
        if (guessCounter == 1)
            return "You're a mind reader!";
        else if (guessCounter <= 4)
            return "Most impressive.";
        else if (guessCounter <= 6)
            return "You can do better than that.";
        else
            return "Better luck next time.";
    }
}
