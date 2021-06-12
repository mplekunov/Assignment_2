package ex40.Base;

import ex39.Base.Converter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ConverterTest {

    @Test
    @DisplayName("correctly convert from string to defined data format")
    void convertStringToDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate nowDate = LocalDate.now();

        String now = dtf.format(nowDate);
        LocalDate actualDate = Converter.convertStringToDate(now, "dd-MM-yyyy");

        assertNotNull(actualDate);
        assertEquals(nowDate, actualDate);
    }
}