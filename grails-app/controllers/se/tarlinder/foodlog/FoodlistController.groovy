package se.tarlinder.foodlog

import se.tarlinder.foodlog.domain.Food

class FoodlistController {

    static scaffold = Food

    def index() {
        [food: Food.all.sort()]
    }
}
