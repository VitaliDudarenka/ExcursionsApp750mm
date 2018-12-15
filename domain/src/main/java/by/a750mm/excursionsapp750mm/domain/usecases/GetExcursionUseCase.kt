package by.a750mm.excursionsapp750mm.domain.usecases

import by.a750mm.excursionsapp750mm.domain.entity.Excursion
import by.a750mm.excursionsapp750mm.domain.executor.PostExecutorThread
import by.a750mm.excursionsapp750mm.domain.repositories.ExcursionRepository
import io.reactivex.Observable
import javax.inject.Inject

class GetExcursionUseCase @Inject constructor(postExecutorThread: PostExecutorThread,
                                              private val excursionRepository: ExcursionRepository) : BaseUseCase(postExecutorThread) {


    fun get(): Observable<List<Excursion>> {
        return excursionRepository.get().observeOn(postExecutorThread).subscribeOn(workExecutorThread)
    }


}



