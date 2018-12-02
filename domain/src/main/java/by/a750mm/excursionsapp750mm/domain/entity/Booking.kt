package by.a750mm.excursionsapp750mm.domain.entity

data class Booking(val id: String, val name: String, val customerName: String, val customerSurname: String,
                   val number: String, val email: String, val seats: Int, val note: String) : DomainEntity {
}