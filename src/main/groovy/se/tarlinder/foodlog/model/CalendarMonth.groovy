package se.tarlinder.foodlog.model

import java.time.LocalDate
import java.time.format.DateTimeFormatter

class CalendarMonth {

    static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd")
    private static final SV_SE = new Locale("sv", "SE")
    private LocalDate date
    private calendarDays = []

    CalendarMonth(LocalDate date) {
        this.date = date
        LocalDate monthStartDate = date.withDayOfMonth(1)
        LocalDate calendarDate = monthStartDate.minusDays(Math.abs(1 - monthStartDate.getDayOfWeek().value))
        for (; calendarDate <= date.withDayOfMonth(date.lengthOfMonth()); calendarDate = calendarDate.plusDays(1)) {
            calendarDays << calendarDate.format(FORMATTER)
        }
    }

    String name() {
        date.format(DateTimeFormatter.ofPattern("MMMM", SV_SE)).capitalize()
    }

    def dates() {
        calendarDays
    }
}