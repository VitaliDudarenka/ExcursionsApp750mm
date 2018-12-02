package by.a750mm.excursionsapp750mm.data.db.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "portfolio")
data class PortfolioDB(@PrimaryKey val id: String, val name: String, val imgUrl: String,
                       val articleUrl: String) {
}