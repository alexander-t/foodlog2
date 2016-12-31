package se.tarlinder.foodlog.domain

class Meal implements Comparable<Meal> {

    long id
    Day day
    Food food
    Long portionInGrams

    static belongsTo = Day
    static constraints = {
        id nullable: false
        food nullable: false
    }

    @Override
    int compareTo(Meal otherMeal) {
        id - otherMeal.id
    }
}
