package de.eiswind.training.hibernate.logic

import de.eiswind.training.hibernate.domain.DriverBreak
import de.eiswind.training.hibernate.domain.Trip
import de.eiswind.training.hibernate.util.PersistenceHelper
import de.eiswind.training.hibernate.util.PersistenceHelper.callInHibernate

class TripService {

    fun getAllDriverBreaks(tripId: String?): MutableList<DriverBreak> {
        return TODO()
    }

    fun getTripsWithLunchBreak(): List<Trip> {

        return TODO()

    }

    fun getTripsWithLongBreaks(duration: Int): MutableList<Trip> {
        return TODO()
    }
}

