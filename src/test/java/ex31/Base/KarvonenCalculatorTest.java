package ex31.Base;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class KarvonenCalculatorTest {

    @Test
    @DisplayName("calculateHeartRate returns correct values")
    void calculateHeartRate_Return_Correct_Values() {
        KarvonenCalculator karvonenCalculator = new KarvonenCalculator(22, 65);
        assertEquals(138, karvonenCalculator.calculateHeartRate(55));
        assertEquals(145, karvonenCalculator.calculateHeartRate(60));
        assertEquals(151, karvonenCalculator.calculateHeartRate(65));
    }

    @Test
    @DisplayName("readInput should ignore incorrect input")
    void readInput_Should_Not_Take_Non_Numeric_Values() {
        InputStream defIn = System.in;

        System.setIn(new ByteArrayInputStream(("a\r\nq\r\n3\r\n").getBytes()));

        assertEquals(3, Main.readInput("test"));

        System.setIn(defIn);
    }
}