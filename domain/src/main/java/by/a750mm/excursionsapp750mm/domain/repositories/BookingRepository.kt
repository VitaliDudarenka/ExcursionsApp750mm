package by.a750mm.excursionsapp750mm.domain.repositories

import by.a750mm.excursionsapp750mm.domain.entity.Booking
import io.reactivex.Observable

interface BookingRepository : BaseRepository {
    fun add(booking: Booking): Observable<Booking>
}