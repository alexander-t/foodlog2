package se.tarlinder.foodlog

import se.tarlinder.foodlog.domain.DataPoint
import se.tarlinder.foodlog.domain.DataPointType
import se.tarlinder.foodlog.domain.Day
import se.tarlinder.foodlog.util.TimeUtil

class DatapointController {

    def index() {
        final date = TimeUtil.parseStandardDate(params.date)
        def pageParams = [date: params.date, dataPointTypes: DataPointType.all]

        def day = Day.findByDateAndUser(date, session.user)
        if (day != null) {
            pageParams.day = day
        } else {
            pageParams.day = new Day(date, session.user)
        }
        return pageParams
    }

    def add() {
        final date = TimeUtil.parseStandardDate(params.date)
        def day = Day.findByDateAndUser(date, session.user)
        if (day == null) {
            day = new Day(date, session.user)
            day.save(flush: true, failOnError: true)
        }
        addDataPoint(day, DataPointType.get(params.dataPointTypeId), params.value)
        redirect(controller: "calendar", action: "index")
    }

    def addDataPoint(Day day, DataPointType dataPointType, String value) {
        DataPoint dataPoint = new DataPoint()
        dataPoint.day = day
        dataPoint.dataPointType = dataPointType
        dataPoint.value = value
        dataPoint.save(flush: true, failOnError: true)
        day.refresh()
    }
}
