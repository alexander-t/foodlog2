package se.tarlinder.foodlog

import grails.util.GrailsUtil
import se.tarlinder.foodlog.domain.Food
import se.tarlinder.foodlog.domain.User
import se.tarlinder.foodlog.domain.WorkoutType

class BootStrap {

    def init = { servletContext ->
        if (GrailsUtil.developmentEnv) {
            new User(name: 'user', password: 'user').save()
            new User(name: 'admin', password: 'admin', admin: true, kcalPerDay: 2500.0, energyBalance: 2800.0).save()
            new Food(name: 'Keso Mini',kcal: 70, protein: 11, carbohydrate: 2.5, fat: 1.5, category: 'DAIRY', packSizeInGrams:250).save()
            new WorkoutType(name: 'Bodypump', averageKcal: 600).save()
        }
    }

    def destroy = {
    }
}
