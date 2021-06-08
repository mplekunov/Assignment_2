/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex25.Base;

import java.util.List;

public final class PasswordStrengthDetector {
    private PasswordStrengthDetector() {}

    public static PasswordStrength passwordValidator(List<PasswordFlags> password) {

        if (password.contains(PasswordFlags.CONTAINS_ONLY_NUMBERS)
                && password.contains(PasswordFlags.CONTAINS_FEWER_THAN_EIGHT_CHARACTERS))
            return PasswordStrength.VERY_WEAK;
        else if (password.contains(PasswordFlags.CONTAINS_ONLY_LETTERS)
                && password.contains(PasswordFlags.CONTAINS_FEWER_THAN_EIGHT_CHARACTERS))
            return PasswordStrength.WEAK;
        else if (password.contains(PasswordFlags.CONTAINS_AT_LEAST_ONE_LETTER)
                && password.contains(PasswordFlags.CONTAINS_AT_LEAST_ONE_NUMBER)
                && password.contains(PasswordFlags.CONTAINS_AT_LEAST_EIGHT_CHARACTERS)) {

            if (password.contains(PasswordFlags.CONTAINS_AT_LEAST_SPECIAL_CHARACTER))
                return PasswordStrength.VERY_STRONG;

            return PasswordStrength.STRONG;
        }

        return PasswordStrength.VERY_WEAK;
    }
}
