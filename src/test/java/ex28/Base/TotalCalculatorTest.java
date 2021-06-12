/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex28.Base;

import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TotalCalculatorTest {
    private final InputStream defIn = System.in;

    @AfterEach
    void tearDown() {
        System.setIn(defIn);
    }

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
    @DisplayName("Ignores non-numeric values according to constraints")
    void fillNumberCollection_Ignores_Non_Numeric_Values() {
        System.setIn(new ByteArrayInputStream(("3\na\n4\na\n4\n").getBytes()));

        List<Double> actual = Main.fillNumberCollection();

        assertEquals(List.of(4.0), actual);
    }
}