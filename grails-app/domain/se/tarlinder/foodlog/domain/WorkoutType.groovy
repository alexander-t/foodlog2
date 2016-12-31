package se.tarlinder.foodlog.domain

class WorkoutType {

    long id
    String name
    int averageKcal

    static constraints = {
        id nullable: false
        name blank: false, nullable: false
        averageKcal nullable: false
    }
}

