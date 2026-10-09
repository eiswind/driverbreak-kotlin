package de.eiswind.training.hibernate.domain

import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.MappedSuperclass
import jakarta.persistence.SequenceGenerator

@MappedSuperclass
@SequenceGenerator(name = "SEQ_APP", sequenceName = "SEQ_APP")
abstract class BaseEntity {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_APP")
    @Id
    var id: Int? = null
        protected set

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o !is BaseEntity) return false
        val other = o
        return this.id != null && this.id == other.id
    }

    override fun hashCode(): Int {
        return 31
    }
}
