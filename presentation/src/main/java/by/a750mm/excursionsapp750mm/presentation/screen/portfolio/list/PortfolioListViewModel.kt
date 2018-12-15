package by.a750mm.excursionsapp750mm.presentation.screen.portfolio.list

import android.databinding.ObservableBoolean
import by.a750mm.excursionsapp750mm.domain.entity.Portfolio
import by.a750mm.excursionsapp750mm.domain.usecases.GetPortfolioUseCase
import by.a750mm.excursionsapp750mm.presentation.app.App
import by.a750mm.excursionsapp750mm.presentation.base.BaseViewModel
import by.a750mm.excursionsapp750mm.presentation.screen.portfolio.PortfolioRouter
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class PortfolioListViewModel : BaseViewModel<PortfolioRouter>() {
    var adapter: PortfolioListAdapter? = PortfolioListAdapter()
    val isProgressEnabled = ObservableBoolean(false)
    @Inject
    lateinit var portfolioListUseCase: GetPortfolioUseCase


    init {
        App.appComponent.inject(this)
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