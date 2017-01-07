package se.tarlinder.foodlog.model

import spock.lang.Specification
import spock.lang.Unroll

import java.time.LocalDate

@Unroll
class CalendarMonthSpec extends Specification {

    void "Month names are in Swedish and capitalized"() {

        given:
        def month = new CalendarMonth(LocalDate.of(2017, 1, 1))

        expect:
        month.name() == "Januari"
    }

    void "Calendar start dates are padded with days from the previous month"(date, expectedRange) {
        given:
        def month = new CalendarMonth(date)

        expect:
        month.dates() == expectedRange.collect { it.toString() }

        where:
        date                        | expectedRange
        LocalDate.of(2017, 1, 1)    | (20161226..20161231).plus(20170101..20170131)
        LocalDate.of(2017, 2, 1)    | (20170130..20170131).plus(20170201..20170228)
        LocalDate.of(2017, 3, 1)    | (20170227..20170228).plus(20170301..20170331)
        LocalDate.of(2017, 4, 1)    | (20170327..20170331).plus(20170401..20170430)
        LocalDate.of(2017, 5, 1)    | 20170501..20170531
        LocalDate.of(2017, 10, 1)   | (20170925..20170930).plus(20171001..20171031)
    }

    void "Day in month doesn't affect padding"(date, expectedRange) {
        given:
        def month = new CalendarMonth(date)

        expect:
        month.dates() == expectedRange.collect { it.toString() }

        where:
        date                        | expectedRange
        LocalDate.of(2017, 1, 7)    | (20161226..20161231).plus(20170101..20170131)
        LocalDate.of(2017, 2, 28)   | (20170130..20170131).plus(20170201..20170228)
        LocalDate.of(2017, 3, 10)   | (20170227..20170228).plus(20170301..20170331)
        LocalDate.of(2017, 4, 1)    | (20170327..20170331).plus(20170401..20170430)
        LocalDate.of(2017, 5, 31)   | 20170501..20170531
    }
}
