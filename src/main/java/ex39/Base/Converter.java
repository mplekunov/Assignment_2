package ex39.Base;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class Converter {
    private Converter() {}

    public static Date convertStringToDate(String date, String dateFormat) {
        try {
            return new SimpleDateFormat(dateFormat).parse(date);
        } catch (ParseException pe) {
            return null;
        }
    }
}
