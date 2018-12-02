package by.a750mm.excursionsapp750mm.presentation.screen.excursion.list

import android.databinding.ObservableBoolean
import by.a750mm.excursionsapp750mm.domain.entity.Excursion
import by.a750mm.excursionsapp750mm.domain.usecases.GetExcursionUseCase
import by.a750mm.excursionsapp750mm.presentation.app.App
import by.a750mm.excursionsapp750mm.presentation.base.BaseViewModel
import by.a750mm.excursionsapp750mm.presentation.screen.excursion.ExcursionRouter
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class ExcursionListViewModel : BaseViewModel<ExcursionRouter>() {
    var adapter: ExcursionListAdapter? = ExcursionListAdapter()
    val isProgressEnabled = ObservableBoolean(false)
    @Inject
    public lateinit var excursionListUseCase: GetExcursionUseCase


    init {
        App.appComponent.inject(this)
        isProgressEnabled.set(true)
        val disposable = excursionListUseCase.get().subscribeBy(
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
        adapter?.onItemClickListener = object : ExcursionListAdapter.OnItemClickListener {
            override fun onItemClick(excursion: Excursion) {
                router!!.goToExcursionDetails(excursion.id)
            }
        }
    }

    fun dismissAdapter() {
        adapter = null
    }

}