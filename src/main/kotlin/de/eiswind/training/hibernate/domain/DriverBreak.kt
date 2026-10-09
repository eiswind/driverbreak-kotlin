package de.eiswind.training.hibernate.domain

class DriverBreak() : BaseEntity() {

    var driverName: String = ""
    var durationInMinutes: Int = 0
    var trip: Trip? = null
}
