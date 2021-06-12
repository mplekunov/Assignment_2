/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex37.Base;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.*;

class PasswordGeneratorTest {
    private static final int NUMBER_OF_TESTS = 10000;

    enum Identifiers {
        NUMBER_QTY,
        SPECIAL_CHAR_QTY,
        LENGTH
    }

    private static final ArrayList<HashMap<Identifiers, Integer>> passwordIdentifiers = new ArrayList<>();
    private static final ArrayList<PasswordGenerator> passwords = new ArrayList<>();

    public PasswordGeneratorTest() {
        for (int i = 0; i < NUMBER_OF_TESTS; i++) {
            passwordIdentifiers.add(new HashMap<>());

            int numQTY = getRandomInteger();
            int charQTY = getRandomInteger();
            int length = getRandomInteger();

            passwordIdentifiers.get(i).put(Identifiers.NUMBER_QTY, numQTY);
            passwordIdentifiers.get(i).put(Identifiers.SPECIAL_CHAR_QTY, charQTY);
            passwordIdentifiers.get(i).put(Identifiers.LENGTH, length);

            passwords.add(new PasswordGenerator(numQTY, charQTY, length));

        }
    }

    @Test
    @DisplayName("Check password generator")
    void generatePassword() {
        String passwordToTest;

        for (int i = 0; i < NUMBER_OF_TESTS; i++) {
            passwordToTest = passwords.get(i).generatePassword().getPassword();

            int numberQTY = passwordIdentifiers.get(i).get(Identifiers.NUMBER_QTY);
            int charQTY = passwordIdentifiers.get(i).get(Identifiers.SPECIAL_CHAR_QTY);
            int length = passwordIdentifiers.get(i).get(Identifiers.LENGTH);

            System.out.println(passwordToTest); //for visual testing

            assertTrue(passwordToTest.matches(getRegex(numberQTY, charQTY, length)));
        }
    }

    private String getRegex(int numberQTY, int charQTY, int length) {
        return ("^(?=.{" + length + ",})(?=(?:[^0-9]*[0-9]){" + numberQTY + "})(?=(?:[^a-zA-Z]*[a-zA-Z]){" + (numberQTY + charQTY) + ",})(?=(?:[^!?#$%^&*]*[!?#$%^&*]){" + charQTY + "}).*$");
    }

    private int getRandomInteger() {
        return ThreadLocalRandom.current().nextInt(1, 16);
    }

}