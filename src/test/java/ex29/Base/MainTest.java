package ex29.Base;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.ProviderNotFoundException;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    @DisplayName("Throws an Arithmetic exception, division by 0")
    void calculateTimeRequiredForDoublingInvestment_Throws_Exception_Division_By_0() {
        assertThrows(ArithmeticException.class, () -> Investment.calculateTimeRequiredForDoublingInvestment(0));
    }

    @Test
    @DisplayName("Ignores Non-Numeric Values")
    void main_Ignores_Non_Numeric_Values() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(("a\r\ni\r\nk\r\n").getBytes());
        InputStream def = System.in;
        System.setIn(inputStream);

        assertThrows(NoSuchElementException.class, () -> Main.main(new String[0]));
        System.setIn(def);
    }

    @Test
    @DisplayName("Correctly calculates output")
    void calculateTimeRequiredForDoublingInvestment_Returns_Correct_Value() {

        assertEquals(18, Investment.calculateTimeRequiredForDoublingInvestment(4));

    }
}