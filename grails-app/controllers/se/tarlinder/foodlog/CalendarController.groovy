package se.tarlinder.foodlog

import se.tarlinder.foodlog.model.Month

class CalendarController {

    def index() {
        [month: new Month(Calendar.getInstance(TimeZone.getTimeZone("GMT+1")))]
    }
}
