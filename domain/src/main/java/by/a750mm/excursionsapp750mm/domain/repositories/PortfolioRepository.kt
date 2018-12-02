package by.a750mm.excursionsapp750mm.domain.repositories

import by.a750mm.excursionsapp750mm.domain.entity.Excursion
import by.a750mm.excursionsapp750mm.domain.entity.Portfolio
import io.reactivex.Observable

interface PortfolioRepository : BaseRepository {
    fun get(): Observable<List<Portfolio>>
    fun getById(id: String): Observable<Portfolio>
}