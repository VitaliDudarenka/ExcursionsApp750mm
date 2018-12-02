package by.a750mm.excursionsapp750mm.domain.usecases

import by.a750mm.excursionsapp750mm.domain.entity.Excursion
import by.a750mm.excursionsapp750mm.domain.executor.PostExecutorThread
import by.a750mm.excursionsapp750mm.domain.repositories.ExcursionRepository
import io.reactivex.Observable

class GetByIdUseCase(postExecutorThread: PostExecutorThread,
                     private val excursionRepository: ExcursionRepository) : BaseUseCase(postExecutorThread) {
    fun getById(id: String): Observable<Excursion> {
        return excursionRepository.getById(id).observeOn(postExecutorThread).subscribeOn(workExecutorThread)
    }
}