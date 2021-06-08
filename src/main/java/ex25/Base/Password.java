/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex25.Base;

import java.util.ArrayList;
import java.util.List;

public class Password {
    private String password;
    private List<PasswordFlags> flags;
    private PasswordStrength strength;

    public Password(String password) {
        this.password = password;
        setPasswordFlags();
        this.strength = PasswordStrengthDetector.passwordValidator(this.flags);
    }

    private void setPasswordFlags() {
        flags = new ArrayList<>();

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
        else if (password.matches("(?=.*[0-9])(?=.*[A-Za-z]).+")) {
            flags.add(PasswordFlags.CONTAINS_AT_LEAST_ONE_LETTER);
            flags.add(PasswordFlags.CONTAINS_AT_LEAST_ONE_NUMBER);

            if (password.matches("(?=.*[0-9])(?=.*[A-Za-z])(?=.*[@#$%^&+=]).+"))
                flags.add(PasswordFlags.CONTAINS_AT_LEAST_SPECIAL_CHARACTER);
        }
    }

    private List<PasswordFlags> getFlags() {
        return flags;
    }

    public String getPassword() {
        return password;
    }

    public PasswordStrength getStrength() {
        return strength;
    }
}
