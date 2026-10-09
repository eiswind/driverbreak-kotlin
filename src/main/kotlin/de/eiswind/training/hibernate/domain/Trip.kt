package de.eiswind.training.hibernate.domain

class Trip() : BaseEntity() {

    var tripId: String? = null

    var driverBreaks: MutableSet<DriverBreak> = mutableSetOf<DriverBreak>()

    fun addDriverBreak(driverBreak: DriverBreak) {
        driverBreak.trip == this
        this.driverBreaks.add(driverBreak)
    }
}
