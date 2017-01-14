package se.tarlinder.foodlog.domain

class User {

    long id
    String name
    String password
    boolean admin = false
    float kcalPerDay = 2000.0
    float kcalEnergyBalance = 2400.0

    static mapping = {

        // Remap this to avoid postgres sadness
        table 'users'
    }

    static constraints = {
        name(nullable: false, blank: false)
        password(blank: false, password: true)
        kcalPerDay(nullable: false)
        kcalEnergyBalance(nullable: false)
    }
}


