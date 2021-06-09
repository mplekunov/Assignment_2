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

import static org.junit.jupiter.api.Assertions.*;

class TotalCalculatorTest {
    private final InputStream stdInputStream = System.in;

    private void getInput(@NotNull String input) {
       System.setIn(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));
    }

    @AfterEach
    public void tearDown() {
        System.setIn(stdInputStream);
    }

    @Test
    @DisplayName("calculateTotal asks for the correct number of numbers")
    void calculateTotal_Read_Specific_Number_Of_Inputs() {
        //From 3 inputs, only two should be used in calculation
        getInput("1\n" +
                "2\n" +
                "3\n");

        double total = TotalCalculator.calculateTotal(2, "");
        assertEquals(3, total);
    }

    @Test
    @DisplayName("calculateTotal ignores non-numeric values according to constraints")
    void calculateTotal_Ignore_Non_Numeric_Values() {
        //inputs
        getInput("1\n");

        double total = TotalCalculator.calculateTotal(1, "");
        assertEquals(1, total);
    }

    @Test
    @DisplayName("calculateTotal gives correct output")
    void calculateTotal_Returns_Correct_Calculation() {
        //inputs
        getInput("1");

        double total = TotalCalculator.calculateTotal(1, "");
        assertEquals(15, total);
    }
}