package se.tarlinder.foodlog.model

import spock.lang.Specification

import java.time.LocalDate

class MonthSpec extends Specification {

    void "Month names are in Swedish and capitalized"() {

        given:
        def month = new Month(LocalDate.of(2017, 1, 1))

        expect:
        month.name() == "Januari"
    }

    void "Month with 31 days"() {
        given:
        def month = new Month(LocalDate.of(2017, 3, 1))

        expect:
        month.dates() == (20170301..20170331).collect { it.toString() }
    }

    void "February in 2017 has 28 days"() {
        given:
        def month = new Month(LocalDate.of(2017, 2, 1))

        expect:
        month.dates() == (20170201..20170228).collect { it.toString() }
    }

}
