package se.tarlinder.foodlog

import se.tarlinder.foodlog.model.CalendarMonth

import java.time.LocalDate
import java.time.ZoneId

class CalendarController {

    def index() {
        [month: new CalendarMonth(LocalDate.now(ZoneId.of("GMT+1"))),
         today: LocalDate.now().format(CalendarMonth.FORMATTER)]
    }
}
