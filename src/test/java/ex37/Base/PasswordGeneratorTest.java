package ex37.Base;

import kotlin.text.Regex;
import org.intellij.lang.annotations.RegExp;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PasswordGeneratorTest {
    private static final int NUMBER_OF_TESTS = 10;
    enum Identifiers {
        NUMBER_QTY,
        SPECIAL_CHAR_QTY,
        LENGTH
    }

    private static final ArrayList<HashMap<Identifiers, Integer>> passwordsInfo = new ArrayList<>(NUMBER_OF_TESTS);
    private static final ArrayList<PasswordGenerator> passwords = new ArrayList<>();

    public PasswordGeneratorTest() {
        for (int i = 0; i < NUMBER_OF_TESTS; i++)
            passwordsInfo.add(new HashMap<>());

            passwordsInfo.forEach(o -> {
                o.put(Identifiers.NUMBER_QTY, getRandomInteger());
                o.put(Identifiers.SPECIAL_CHAR_QTY, getRandomInteger());
                o.put(Identifiers.LENGTH, getRandomInteger());
            });

        passwordsInfo.forEach(o ->
            passwords.add(new PasswordGenerator(o.get(Identifiers.NUMBER_QTY), o.get(Identifiers.SPECIAL_CHAR_QTY), o.get(Identifiers.LENGTH)))
        );
    }

    @Test
    @DisplayName("Check password generator")
    void generatePassword() {
        String passwordToTest;

        for (int i = 0; i < NUMBER_OF_TESTS; i++) {
            passwordToTest = passwords.get(i).generatePassword().getPassword();

            int numberQTY = passwordsInfo.get(i).get(Identifiers.NUMBER_QTY);
            int charQTY = passwordsInfo.get(i).get(Identifiers.SPECIAL_CHAR_QTY);
            int length = passwordsInfo.get(i).get(Identifiers.LENGTH);

            assertTrue(passwordToTest.matches(getRegex(numberQTY, charQTY, length)));
        }
    }

    private String getRegex(int numberQTY, int charQTY, int length) {
        return ("^(?=(?:[^0-9]*[0-9]){" + numberQTY + ",})(?=(?:[^a-zA-Z]*[a-zA-Z]){" + (numberQTY + charQTY) + ",})(?=(?:[^!?#$%^&*]*[!?#$%^&*]){" + charQTY + ",}).*$");
    }

    private int getRandomInteger() {
        return ThreadLocalRandom.current().nextInt(1, 16);
    }

}