package de.eiswind.training.hibernate

import de.eiswind.training.hibernate.domain.CoffeeBreak
import de.eiswind.training.hibernate.domain.DriverBreak
import de.eiswind.training.hibernate.domain.LunchBreak
import de.eiswind.training.hibernate.domain.Trip
import de.eiswind.training.hibernate.logic.TripService
import de.eiswind.training.hibernate.util.PersistenceHelper.doInHibernate
import de.eiswind.training.hibernate.util.PersistenceHelper.withTransaction
import jakarta.persistence.EntityManager
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class DriverBreakTest {
    private val tripService = TripService()

    lateinit var trip1: Trip
    lateinit var trip2: Trip

    lateinit var lunchBreakHorst: LunchBreak
    lateinit var coffeeBreakJohn: CoffeeBreak


    lateinit var em: EntityManager

    @BeforeEach
    fun setup() {
        doInHibernate({ em ->
            withTransaction(em, {
                trip1 = Trip()
                trip1.tripId="A"
                trip2 = Trip()
                trip2.tripId="B"

                lunchBreakHorst = LunchBreak()
                lunchBreakHorst.driverName ="Horst"
                lunchBreakHorst.durationInMinutes=45
                lunchBreakHorst.pizzaType="Salami"
                coffeeBreakJohn = CoffeeBreak()
                coffeeBreakJohn.driverName="John"
                coffeeBreakJohn.durationInMinutes =5
                coffeeBreakJohn.isUsedFilterCoffee=true
                trip1.addDriverBreak(lunchBreakHorst)
                trip2.addDriverBreak(coffeeBreakJohn)

                em.persist(trip1)
                em.persist(trip2)
            })
        })
    }

    @AfterEach
    fun cleanup() {
        doInHibernate({ em ->
            withTransaction(em, {
                em.createQuery("DELETE FROM DriverBreak").executeUpdate()
                em.createQuery("DELETE FROM Trip").executeUpdate()
            })
        })
    }


    @Test
    @Disabled
    fun getAllDispatcherBreaks() {
        val driverBreaks: MutableList<DriverBreak> = tripService.getAllDriverBreaks("A")
        Assertions.assertTrue(driverBreaks.contains(lunchBreakHorst))
        Assertions.assertFalse(driverBreaks.contains(coffeeBreakJohn))
    }


    @Test
    @Disabled
    fun getTripsWithLunchBreak() {
        val trips= tripService.getTripsWithLunchBreak()
        Assertions.assertTrue(trips.contains(trip1))
        Assertions.assertFalse(trips.contains(trip2))
    }

    @Test
    @Disabled
    fun getTripsWithLongBreaks() {
        val trips = tripService.getTripsWithLongBreaks(8)
        Assertions.assertTrue(trips.contains(trip1))
        Assertions.assertFalse(trips.contains(trip2))
    }
}
