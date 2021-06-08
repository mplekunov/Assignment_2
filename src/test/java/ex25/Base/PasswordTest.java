/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex25.Base;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordTest {

    @Test
    @DisplayName("getStrength() should return very weak")
    void getStrength_Returns_VeryWeak() {
        assertEquals(PasswordStrength.VERY_WEAK, new Password("12345").getStrength(),
                "Only Numbers and less than 8 characters");
    }

    @Test
    @DisplayName("getStrength() should return weak")
    void getStrength_Returns_Weak() {
        assertEquals(PasswordStrength.WEAK, new Password("abcdef").getStrength(),
                "Only letters and less than 8 characters");
    }

    @Test
    @DisplayName("getStrength() should return strong")
    void getStrength_Returns_Strong() {
        assertEquals(PasswordStrength.STRONG, new Password("abc123xyz").getStrength(),
                "At least one letter, one number and more than 8 characters");
    }

    @Test
    @DisplayName("getStrength() should return very strong")
    void getStrength_Returns_VeryStrong() {
        assertEquals(PasswordStrength.VERY_STRONG, new Password("1337h@xor!").getStrength(),
                "At least one letter, one number, one special character and more than 8 characters");
    }

}