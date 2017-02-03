package se.tarlinder.service

import grails.test.mixin.integration.Integration
import grails.transaction.Rollback
import org.springframework.beans.factory.annotation.Autowired
import se.tarlinder.foodlog.domain.Day
import se.tarlinder.foodlog.domain.Food
import se.tarlinder.foodlog.domain.User
import se.tarlinder.foodlog.service.MealService
import spock.lang.Specification

@Integration
@Rollback
class MealServiceSpec extends Specification {

    @Autowired
    MealService testedService

    User user
    Food kesoMini

    def setup() {
        user = User.findByName("user")
        kesoMini = Food.findByName('Keso Mini')
    }

    def "Add a meal"() {
        given:
        def day = new Day("20170101", user)
        day.save(flush: true)

        when:
        testedService.addMeal(day, kesoMini, 100)

        then:
        def meal = Day.findByDate("20170101").meals[0]
        meal.day.equals(day)
        meal.portionInGrams == 100
    }
}
