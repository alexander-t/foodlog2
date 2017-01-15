package se.tarlinder.foodlog.sp

import grails.test.mixin.integration.Integration
import grails.transaction.Rollback
import groovy.sql.Sql
import org.springframework.beans.factory.annotation.Autowired
import se.tarlinder.foodlog.domain.Day
import se.tarlinder.foodlog.domain.Food
import se.tarlinder.foodlog.domain.Meal
import se.tarlinder.foodlog.domain.User
import se.tarlinder.foodlog.domain.Workout
import se.tarlinder.foodlog.domain.WorkoutType
import spock.lang.Ignore
import spock.lang.Specification

import javax.sql.DataSource

@Integration
@Rollback
class ComputeTotalStatsSpec extends Specification {

    @Autowired
    DataSource dataSource

    User user
    Food kesoMini
    WorkoutType bodypump
    Sql sql

    def setup() {
        user = User.findByName("user")
        kesoMini = Food.findByName('Keso Mini')
        bodypump = WorkoutType.findByName('Bodypump')

        sql = new Sql(dataSource)
    }

    def "Happy path: three consecutive days with some simple stats"() {

        given: 'A first day with an intake of 70 kcal'
        def d1 = new Day(date: "20170101", user: user).save()
        new Meal(day: d1, food: kesoMini, portionInGrams: 100).save(flush: true)

        and: 'A second day with an intake of 140 kcal and a bodypump class (500 kcal)'
        def d2 = new Day(date: "20170102", user: user).save()
        new Meal(day: d2, food: kesoMini, portionInGrams: 200).save()
        new Workout(day: d2, workoutType: bodypump, usedKcal: 500).save(flush: true)

        and: 'A third day with an intake of 210 kcal and a bodypump class (600 kcal)'
        def d3 = new Day(date: "20170103", user: user).save()
        new Meal(day: d3, food: kesoMini, portionInGrams: 300).save()
        new Workout(day: d3, workoutType: bodypump, usedKcal: 600).save(flush: true)

        when:
        def (daysOnDiet, foodKcal, workoutKcal) = callTestedProcedure(sql)

        then:
        daysOnDiet == 3
        foodKcal == 420
        workoutKcal == 1100
    }

    def "Return just zeros if no days are recorded"() {
        expect:
        [0, 0, 0] == callTestedProcedure(sql)
    }

    @Ignore
    def "There may be gaps between diet days"() {
        given: 'Three days spaced apart'
        new Day(date: "20170101", user: user).save(flush:true)
        new Day(date: "20170115", user: user).save(flush:true)
        new Day(date: "20170205", user: user).save(flush:true)

        expect:
        [36, 0, 0] == callTestedProcedure(sql)
    }

    def callTestedProcedure(Sql sql) {
        sql.firstRow("select compute_total_stats()")["compute_total_stats"].value
                .replaceAll(/[^\d,]/, "")
                .split(/,/, -1).collect { Integer.parseInt(it) }
    }
}
