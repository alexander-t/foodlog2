package se.tarlinder.foodlog.domain

import se.tarlinder.foodlog.model.DayTotals

class Day {

    long id
    String date
    User user

    static hasMany = [meals: Meal, workouts: Workout, dataPoints: DataPoint]
    static constraints = {
        id nullable: false
        date size: 8..8, nullable: false, unique: 'user'
    }
    static mapping = {
        id generator:'sequence', params:[sequence:'day_id_seq']
    }

    Day(String date, User user) {
        this.date = date
        this.user = user
        this.meals = []
    }

    @Override
    String toString() {
        return "Day{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", user=" + user +
                '}'
    }

    DayTotals getTotals() {
        def totals = new DayTotals()
        meals.each { totals.addMeal(it)}
        workouts.each { totals.addWorkout(it)}
        return totals
    }

}
