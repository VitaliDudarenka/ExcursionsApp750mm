package by.a750mm.excursionsapp750mm.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import by.a750mm.excursionsapp750mm.data.db.dao.ExcursionDao
import by.a750mm.excursionsapp750mm.data.db.dao.PortfolioDao
import by.a750mm.excursionsapp750mm.data.db.entity.ExcursionDB
import by.a750mm.excursionsapp750mm.data.db.entity.PortfolioDB


@Database(entities = [ExcursionDB::class, PortfolioDB::class], version = 2, exportSchema = false)
abstract class AppDataBase : RoomDatabase() {
    companion object {
        const val DATABASE_NAME = "750mmLocalBase"
        fun getInstance(context: Context): AppDataBase {
            return Room.databaseBuilder(context, AppDataBase::class.java, DATABASE_NAME).fallbackToDestructiveMigration().build()
        }
    }

    abstract fun getExcursionDao(): ExcursionDao
    abstract fun getPortfolioDao(): PortfolioDao

}
