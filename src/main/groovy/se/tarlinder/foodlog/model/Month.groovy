package se.tarlinder.foodlog.model

import java.time.LocalDate
import java.time.YearMonth
import java.time.format.DateTimeFormatter

class Month {

    private static final SV_SE = new Locale("sv", "SE")
    private LocalDate date

    Month(LocalDate date) {
        this.date = date
    }

    String name() {
        date.format(DateTimeFormatter.ofPattern("MMMM", SV_SE)).capitalize()
    }

    def dates() {
        (1..YearMonth.of(date.year, date.month).lengthOfMonth()).collect {
            String.format('%1$4d%2$02d%3$02d', date.year, date.month.value, it)
        }
    }
}