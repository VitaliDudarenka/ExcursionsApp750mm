package by.a750mm.excursionsapp750mm.presentation.screen.portfolio.list

import android.databinding.ObservableBoolean
import by.a750mm.excursionsapp750mm.domain.entity.Excursion
import by.a750mm.excursionsapp750mm.domain.entity.Portfolio
import by.a750mm.excursionsapp750mm.presentation.base.BaseViewModel
import by.a750mm.excursionsapp750mm.presentation.factory.UseCaseProvider
import by.a750mm.excursionsapp750mm.presentation.screen.excursion.ExcursionRouter
import by.a750mm.excursionsapp750mm.presentation.screen.excursion.list.ExcursionListAdapter
import by.a750mm.excursionsapp750mm.presentation.screen.portfolio.PortfolioRouter
import io.reactivex.rxkotlin.subscribeBy

class PortfolioListViewModel : BaseViewModel<PortfolioRouter>() {
    var adapter: PortfolioListAdapter? = PortfolioListAdapter()
    val isProgressEnabled = ObservableBoolean(false)
    private val portfolioListUseCase = UseCaseProvider.providePortfolioListUseCase()


    init {
        isProgressEnabled.set(true)
        val disposable = portfolioListUseCase.get().subscribeBy(
                onNext = {
                    adapter?.listData = it.toMutableList()
                    isProgressEnabled.set(false)
                },
                onError = {
                    isProgressEnabled.set(false)
                    router?.showError(it)
                }
        )
        addToDisposable(disposable)
        adapter?.onItemClickListener = object : PortfolioListAdapter.OnItemClickListener {
            override fun onItemClick(portfolio: Portfolio) {
                router!!.goToPortfolioDetails(portfolio.id)
            }
        }
    }

    fun dismissAdapter() {
        adapter = null
    }

}