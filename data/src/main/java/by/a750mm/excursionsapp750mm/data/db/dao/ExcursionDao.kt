package by.a750mm.excursionsapp750mm.data.db.dao

import android.arch.persistence.room.*
import by.a750mm.excursionsapp750mm.data.db.entity.ExcursionDB
import io.reactivex.Flowable


@Dao
interface ExcursionDao {
    @Insert
    fun insert(excursion: List<ExcursionDB>)

    @Update
    fun update(excursion: ExcursionDB)

    @Delete
    fun delete(excursion: ExcursionDB)

    @Query("DELETE FROM excursion")
    fun deleteAll()

    @Query("SELECT * FROM excursion ORDER BY name")
    fun getAll(): Flowable<List<ExcursionDB>>

    @Query("SELECT * FROM excursion WHERE id = :id LIMIT 1")
    fun getById(id: String): Flowable<ExcursionDB>

    @Query("DELETE FROM excursion WHERE id = :id")
    fun deleteById(id: String)
}