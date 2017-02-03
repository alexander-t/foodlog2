package se.tarlinder.foodlog.service

import grails.transaction.Transactional
import se.tarlinder.foodlog.domain.Day
import se.tarlinder.foodlog.domain.Food
import se.tarlinder.foodlog.domain.Meal

/**
 * Manages meals
 */
@Transactional
class MealService {

    void addMeal(Day day, Food food, long portionInGrams) {
        def meal = new Meal()
        meal.day = day
        meal.food = food
        meal.portionInGrams = portionInGrams
        meal.save(flush: true, failOnError: true)
        day.refresh()
    }
}
