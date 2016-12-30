package se.tarlinder.foodlog

import grails.util.GrailsUtil
import se.tarlinder.foodlog.domain.Food

class BootStrap {

    def init = { servletContext ->
        if (GrailsUtil.developmentEnv) {
    //        new User(name: 'test1', password: 'test1', admin: true, kcalPerDay: 2500.0).save()
    //        new User(name: 'test2', password: 'test2').save()
            new Food(name: 'Keso Mini',kcal: 70, protein: 11, carbohydrate: 2.5, fat: 1.5, category: 'DAIRY', packSizeInGrams:250).save()
      //      new WorkoutType(name: 'Bodypump', averageKcal: 600).save()
        }
    }

    def destroy = {
    }
}
