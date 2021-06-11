package ex39.Base;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public final class Converter {
    private Converter() {}

    public static LocalDate convertStringToDate(String date, String dateFormat) {
        try {
            return LocalDate.parse(date, DateTimeFormatter.ofPattern(dateFormat));
        } catch (DateTimeParseException dtp) {
            return null;
        }
    }
}
