package se.tarlinder.foodlog.model

import java.text.SimpleDateFormat

class Month {

    private Calendar calendar

    Month(Calendar calendar) {
        this.calendar = calendar
    }

    def name() {
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM", new Locale("sv", "SE"));
        sdf.format(calendar.getTime()).capitalize()
    }

    def dates() {

        def dayToSimpleDate = []
        for (day in 1..calendar.getMaximum(Calendar.DAY_OF_MONTH)) {
            dayToSimpleDate << String.format('%1$4d%2$02d%3$02d', calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, day)
        }
        return dayToSimpleDate
    }
}