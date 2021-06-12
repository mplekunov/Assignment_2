/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex39.Base;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

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