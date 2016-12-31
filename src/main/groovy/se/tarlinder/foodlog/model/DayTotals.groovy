package se.tarlinder.foodlog.model

import se.tarlinder.foodlog.domain.Meal
import se.tarlinder.foodlog.domain.Workout

class DayTotals {
    def kcal = 0.0
    def protein = 0.0
    def carbohydrate = 0.0
    def fat = 0.0
    def workoutKcal = 0

    def addMeal(Meal meal) {
        kcal += meal.food.kcal * (meal.portionInGrams / 100)
        protein += meal.food.protein * (meal.portionInGrams / 100)
        carbohydrate += meal.food.carbohydrate * (meal.portionInGrams / 100)
        fat += meal.food.fat * (meal.portionInGrams / 100)
    }

    def addWorkout(Workout workout) {
        workoutKcal += workout.usedKcal;
    }

    def String getTotalKcal(includeDecimal = true) {
        includeDecimal ? String.format("%.1f", kcal) : String.format("%.0f", kcal)
    }

    def String getTotalProtein(includeDecimal = true) {
        String.format("%.1f", protein)
    }

    def String getTotalCarbohydrate(includeDecimal = true) {
        String.format("%.1f", carbohydrate)
    }

    def String getTotalFat(includeDecimal = true) {
        String.format("%.1f", fat)
    }

    def String getTotalWorkoutKcal() {
        "" + workoutKcal
    }
}