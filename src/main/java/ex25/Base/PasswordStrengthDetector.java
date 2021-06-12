/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex25.Base;

import java.util.ArrayList;
import java.util.List;

public final class PasswordStrengthDetector {
    private PasswordStrengthDetector() {}

    public static PasswordStrength passwordValidator(String password) {
        List<PasswordFlags> passwordFlags = getPasswordFlags(password);

        if (passwordFlags.contains(PasswordFlags.CONTAINS_ONLY_NUMBERS)
                && passwordFlags.contains(PasswordFlags.CONTAINS_FEWER_THAN_EIGHT_CHARACTERS))
            return PasswordStrength.VERY_WEAK;
        else if (passwordFlags.contains(PasswordFlags.CONTAINS_ONLY_LETTERS)
                && passwordFlags.contains(PasswordFlags.CONTAINS_FEWER_THAN_EIGHT_CHARACTERS))
            return PasswordStrength.WEAK;
        else if (passwordFlags.contains(PasswordFlags.CONTAINS_AT_LEAST_ONE_LETTER)
                && passwordFlags.contains(PasswordFlags.CONTAINS_AT_LEAST_ONE_NUMBER)
                && passwordFlags.contains(PasswordFlags.CONTAINS_AT_LEAST_EIGHT_CHARACTERS)) {

            if (passwordFlags.contains(PasswordFlags.CONTAINS_AT_LEAST_SPECIAL_CHARACTER))
                return PasswordStrength.VERY_STRONG;

            return PasswordStrength.STRONG;
        }

        return PasswordStrength.VERY_WEAK;
    }

    private static List<PasswordFlags> getPasswordFlags(String password) {
        List<PasswordFlags> flags = new ArrayList<>();

        if (password.length() < 8)
            flags.add(PasswordFlags.CONTAINS_FEWER_THAN_EIGHT_CHARACTERS);
        else
            flags.add(PasswordFlags.CONTAINS_AT_LEAST_EIGHT_CHARACTERS);

        if (password.matches("^[a-zA-Z]+$"))
            flags.add(PasswordFlags.CONTAINS_ONLY_LETTERS);
        else if (password.matches("^[0-9]+$"))
            flags.add(PasswordFlags.CONTAINS_ONLY_NUMBERS);
        else if (password.matches("^[@#$%^&+=]+$"))
            flags.add(PasswordFlags.CONTAINS_ONLY_SPECIAL_CHARACTERS);
        else if (password.matches("^(?=.*[0-9])(?=.*[A-Za-z]).+$")) {
            flags.add(PasswordFlags.CONTAINS_AT_LEAST_ONE_LETTER);
            flags.add(PasswordFlags.CONTAINS_AT_LEAST_ONE_NUMBER);

            if (password.matches("^(?=.*[0-9])(?=.*[A-Za-z])(?=.*[@#$%^&+=]).+$"))
                flags.add(PasswordFlags.CONTAINS_AT_LEAST_SPECIAL_CHARACTER);
        }

        return flags;
    }
}
