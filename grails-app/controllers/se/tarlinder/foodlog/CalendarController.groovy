package se.tarlinder.foodlog

import se.tarlinder.foodlog.trait.IsLoggedIn

class CalendarController implements IsLoggedIn {

    def beforeInterceptor = [action: isLoggedIn()]

    def index() {

    }
}
