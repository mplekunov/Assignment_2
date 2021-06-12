/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex32.Base;

public enum DifficultyLevel {
    FIRST_EASIEST,
    SECOND_EASIEST,
    THIRD_EASIEST;

    public static DifficultyLevel fromInteger(int difficultyLevel) {
        return switch (difficultyLevel) {
            case 1 -> FIRST_EASIEST;
            case 2 -> SECOND_EASIEST;
            case 3 -> THIRD_EASIEST;
            default -> null;
        };

    }
}
