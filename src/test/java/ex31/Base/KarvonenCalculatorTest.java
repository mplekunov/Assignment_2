/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex31.Base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class KarvonenCalculatorTest {
    private final InputStream inDef = System.in;

    @AfterEach
    void tearDown() {
        System.setIn(inDef);
    }

    @ParameterizedTest
    @CsvSource({
            "138, 55",
            "145, 60",
            "151, 65"
    })
    @DisplayName("calculateHeartRate returns correct values")
    void calculateHeartRate_Return_Correct_Values(int expected, int intensity) {
        KarvonenCalculator karvonenCalculator = new KarvonenCalculator(22, 65);
        assertEquals(expected, karvonenCalculator.calculateHeartRate(intensity));
    }

    @Test
    @DisplayName("readInput should ignore incorrect input")
    void readInput_Should_Not_Take_Non_Numeric_Values() {
        System.setIn(new ByteArrayInputStream(("a\r\nq\r\n3\r\n").getBytes()));

        assertEquals(3, Main.readInput("test"));
    }
}