package by.a750mm.excursionsapp750mm.domain.usecases

import by.a750mm.excursionsapp750mm.domain.entity.Portfolio
import by.a750mm.excursionsapp750mm.domain.executor.PostExecutorThread
import by.a750mm.excursionsapp750mm.domain.repositories.PortfolioRepository
import io.reactivex.Observable

class GetPortfolioUseCase (postExecutorThread: PostExecutorThread,
                           private val portfolioRepository: PortfolioRepository) : BaseUseCase(postExecutorThread) {
    fun get(): Observable<List<Portfolio>> {
        return portfolioRepository.get().observeOn(postExecutorThread).subscribeOn(workExecutorThread)
    }


}