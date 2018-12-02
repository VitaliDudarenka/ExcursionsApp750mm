package by.a750mm.excursionsapp750mm.data.db.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.time.LocalDate


@Entity(tableName = "excursion")
data class ExcursionDB(@PrimaryKey val id: String, val name: String, val description: String,
                       val plan: String, val imgUrl: String, val location: String, val nextDate: Long,
                       val seats: Int, val seatsRest: Int) {
}