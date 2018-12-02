package by.a750mm.excursionsapp750mm.domain.usecases

import by.a750mm.excursionsapp750mm.domain.entity.Portfolio
import by.a750mm.excursionsapp750mm.domain.executor.PostExecutorThread
import by.a750mm.excursionsapp750mm.domain.repositories.PortfolioRepository
import io.reactivex.Observable

class GetPortfolioByIdUseCase (postExecutorThread: PostExecutorThread,
                               private val portfolioRepository: PortfolioRepository) : BaseUseCase(postExecutorThread) {
    fun getById(id: String): Observable<Portfolio> {
        return portfolioRepository.getById(id).observeOn(postExecutorThread).subscribeOn(workExecutorThread)
    }
}