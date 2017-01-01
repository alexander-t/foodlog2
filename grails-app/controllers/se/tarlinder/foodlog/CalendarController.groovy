package se.tarlinder.foodlog

import se.tarlinder.foodlog.model.Month

import java.time.LocalDate
import java.time.ZoneId

class CalendarController {

    def index() {
        [month: new Month(LocalDate.now(ZoneId.of("GMT+1")))]
    }
}
