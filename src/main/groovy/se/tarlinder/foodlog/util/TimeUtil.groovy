package se.tarlinder.foodlog.util

import java.text.SimpleDateFormat
import java.text.ParseException

class TimeUtil {
    private static sdf

    static {
        sdf = new SimpleDateFormat("yyyyMMdd");
        sdf.setLenient(false)
    }

    static isToday(dateAsString) {
        return dateAsString.equals(sdf.format(new Date()))
    }

    static parseStandardDate(String dateParameter) {
        if (dateParameter == null || !dateParameter.matches('^\\d{8}$')) {
            throw new IllegalArgumentException("Expected a date with format yyyyMMdd")
        }

        try {
            sdf.parse(dateParameter)
            return dateParameter
        } catch (ParseException e) {
            throw new IllegalArgumentException(e.getMessage())
        }
    }

    static prettyPrint(String date) {
        if (date.length() != 8) {
            return date;
        }
        return date.substring(0, 4) + "-" + date.substring(4, 6) + "-" + date.substring(6, 8);
    }
}
