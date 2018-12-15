package by.a750mm.excursionsapp750mm.domain.usecases

import by.a750mm.excursionsapp750mm.domain.entity.Booking
import by.a750mm.excursionsapp750mm.domain.executor.PostExecutorThread
import by.a750mm.excursionsapp750mm.domain.repositories.BookingRepository
import io.reactivex.Observable
import javax.inject.Inject

class AddBookingUseCase @Inject constructor(postExecutorThread: PostExecutorThread,
                                            private val bookingRepository: BookingRepository) : BaseUseCase(postExecutorThread) {
    fun add(booking: Booking): Observable<Booking> {
        return bookingRepository.add(booking).observeOn(postExecutorThread).subscribeOn(workExecutorThread)
    }
}




