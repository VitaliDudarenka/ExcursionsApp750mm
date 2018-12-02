package by.a750mm.excursionsapp750mm.domain.repositories

import by.a750mm.excursionsapp750mm.domain.entity.Excursion
import io.reactivex.Observable

interface ExcursionRepository : BaseRepository {
    fun get(): Observable<List<Excursion>>
    fun getById(id: String): Observable<Excursion>
}