package se.tarlinder.foodlog

import se.tarlinder.foodlog.domain.Day
import se.tarlinder.foodlog.domain.Food
import se.tarlinder.foodlog.domain.Meal
import se.tarlinder.foodlog.service.MealService
import se.tarlinder.foodlog.util.TimeUtil

class DayController {

    MealService mealService

    def index() {
        final date = TimeUtil.parseStandardDate(params.date)
        def pageParams = [food: Food.all.sort()]

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
        mealService.addMeal(day, Food.get(params.foodId), Long.parseLong(params.portionSize))
        render(view: "index", model: [day: day, food: Food.all.sort()])
    }

    def delete() {
        Meal meal = Meal.get(params.id)
        if (meal == null) {
            throw new IllegalArgumentException("Invalid meal id");
        }

        Day day = Day.findByDateAndUser(params.date, session.user)
        day.meals.remove(meal)
        meal.delete(flush: true)

        if (day.meals.isEmpty()) {
            day.delete(flush: true)
        }
        redirect(action: "index", params: params)
    }
}
