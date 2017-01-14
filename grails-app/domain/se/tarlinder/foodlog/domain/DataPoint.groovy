package se.tarlinder.foodlog.domain

class DataPoint {

    long id
    Day day
    DataPointType dataPointType
    String value

    static belongsTo = Day
    static constraints = {
        id nullable: false
        dataPointType nullable: false
        value nullable: false
    }
}
