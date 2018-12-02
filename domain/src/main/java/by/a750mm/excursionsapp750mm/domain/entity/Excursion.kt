package by.a750mm.excursionsapp750mm.domain.entity

import java.time.LocalDate


data class Excursion(val id: String, val name: String, val description: String,
                     val plan: String, val imgUrl: String, val location: String, val nextDate: Long,
                     val seats: Int, val seatsRest: Int) : DomainEntity {

}