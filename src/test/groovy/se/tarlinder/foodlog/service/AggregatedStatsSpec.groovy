package se.tarlinder.foodlog.service

import se.tarlinder.foodlog.AggregatedStats
import spock.lang.Specification

class AggregatedStatsSpec extends Specification {
    def "Perfectly balanced energy consumption"() {
        given:
        def stats = new AggregatedStats()
        stats.foodKcal = 10000
        stats.energyBalanceKcal = 9700
        stats.workoutKcal = 300

        expect:
        stats.getKcalDiff() == 0
    }

    def "It takes 7700 kcal deficit to lose a kilo"() {
        given:
        def stats = new AggregatedStats()
        stats.foodKcal = 10000
        stats.energyBalanceKcal = 17000
        stats.workoutKcal = 700

        expect:
        stats.getKcalDiff() == -7700
        stats.getKiloDiff() =~ /-1[\.,]0/ // Locales can mess this up
    }

    def "A loss of 0.0 kilos is formatted as 0 without decimal separator"() {
        given:
        def stats = new AggregatedStats()
        stats.foodKcal = 10000
        stats.energyBalanceKcal = 10000

        expect:
        stats.getKiloDiff() == "0"
    }
}
