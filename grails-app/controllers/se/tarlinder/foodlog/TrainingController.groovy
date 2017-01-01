package se.tarlinder.foodlog

import se.tarlinder.foodlog.domain.Day
import se.tarlinder.foodlog.domain.Workout
import se.tarlinder.foodlog.domain.WorkoutType
import se.tarlinder.foodlog.util.TimeUtil

class TrainingController {

    def index() {
        final date = TimeUtil.parseStandardDate(params.date)
        def pageParams = [date: params.date, workoutTypes: WorkoutType.all]

        Day day = Day.findByDateAndUser(date, session.user)
        if (day != null) {
            pageParams.day = day
        } else {
            pageParams.day = new Day(date, session.user)
        }
        return pageParams
    }

    def add() {
        final date = TimeUtil.parseStandardDate(params.date)
        Day day = Day.findByDateAndUser(date, session.user)
        if (day == null) {
            day = new Day(date, session.user)
            day.save(flush: true, failOnError: true)
        }
        addWorkout(day, WorkoutType.get(params.workoutTypeId), Long.parseLong(params.usedKcal))
        redirect(controller: "calendar", action: "index")
    }

    private addWorkout(Day day, WorkoutType workoutType, long usedKcal) {
        Workout workout = new Workout()
        workout.day = day
        workout.workoutType = workoutType
        workout.usedKcal = usedKcal
        workout.save(flush: true, failOnError: true)
        day.refresh()
    }
}
