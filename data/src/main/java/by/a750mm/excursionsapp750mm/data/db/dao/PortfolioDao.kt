package by.a750mm.excursionsapp750mm.data.db.dao

import android.arch.persistence.room.*
import by.a750mm.excursionsapp750mm.data.db.entity.PortfolioDB
import io.reactivex.Flowable

@Dao
interface PortfolioDao {
    @Insert
    fun insert(portfolio: List<PortfolioDB>)

    @Query("DELETE FROM portfolio")
    fun deleteAll()

    @Query("SELECT * FROM portfolio ORDER BY name")
    fun getAll(): Flowable<List<PortfolioDB>>

}