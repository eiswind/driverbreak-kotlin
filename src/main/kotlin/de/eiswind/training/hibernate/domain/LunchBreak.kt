package de.eiswind.training.hibernate.domain

/**
 * Additional data about lunch related driver breaks.
 * NOTE: Assumes, that a driver eats pizza for lunch all the time.
 * TODO: Talk to the system architects, if the assumption about pizza at lunch is reasonable.
 */
class LunchBreak() : DriverBreak() {

    var pizzaType: String = ""
}
