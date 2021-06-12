/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex36.Base;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StatisticsTest {
    private final ArrayList<Double> numbers = new ArrayList<>(List.of(100.0, 200.0, 300.0, 1000.0));
    private final Statistics statistics = new Statistics(numbers);
    @Test
    @DisplayName("getAverage returns correct average")
    void getAverage() {
        assertEquals(400, statistics.getAverage());
    }

    @Test
    @DisplayName("getMin returns correct min")
    void getMin() {
        assertEquals(100, statistics.getMin());
    }

    @Test
    @DisplayName("getMax returns correct max")
    void getMax() {
        assertEquals(1000, statistics.getMax());
    }

    @Test
    @DisplayName("getStandardDeviation returns correct Standard Deviation")
    void getStandardDeviation() {
        assertEquals(353.55, statistics.getStandardDeviation());
    }
}