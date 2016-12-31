package se.tarlinder.foodlog.domain

class Workout {

    long id
    Day day
    WorkoutType workoutType
    long usedKcal

    static belongsTo = Day

    static constraints = {
        id nullable: false
        workoutType nullable: false
        usedKcal nullable: false, min: 0L, max: 9999L
    }
}
