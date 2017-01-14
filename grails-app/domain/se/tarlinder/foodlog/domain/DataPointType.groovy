package se.tarlinder.foodlog.domain

class DataPointType {

    long id
    String name
    String unit

    static constraints = {
        id nullable: false
        name blank: false, nullable: false
        unit  blank: false, nullable: false
    }
}
