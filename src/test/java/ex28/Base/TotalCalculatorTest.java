/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex28.Base;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TotalCalculatorTest {
    @Test
    @DisplayName("2 + 2 + 2 + 2 = 8")
    void calculateTotal_Returns_Correct_Values() {
        List<Double> numbers = new ArrayList<>();
        numbers.add(2.0);
        numbers.add(2.0);
        numbers.add(2.0);
        numbers.add(2.0);

        double total = TotalCalculator.calculateTotal(numbers);
        assertEquals(8, total);
    }

    @Test
    @DisplayName("readInput ignores non-numeric values according to constraints")
    void readInput_Ignores_Non_Numeric_Values() {
        InputStream inputStream = new ByteArrayInputStream(("@\n").getBytes());
        assertNull(Main.readInput(inputStream));
    }
}