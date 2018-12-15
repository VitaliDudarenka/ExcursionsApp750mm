package by.a750mm.excursionsapp750mm.presentation.screen.portfolio.details

import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import by.a750mm.excursionsapp750mm.domain.usecases.GetPortfolioByIdUseCase
import by.a750mm.excursionsapp750mm.presentation.app.App
import by.a750mm.excursionsapp750mm.presentation.base.BaseViewModel
import by.a750mm.excursionsapp750mm.presentation.screen.portfolio.PortfolioRouter
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject


class PortfolioDetailsViewModel : BaseViewModel<PortfolioRouter>() {
    val name = ObservableField<String>(" ")
    val articleUrl = ObservableField<String>(" ")
    private var portfolioId: String? = null
    val isProgressEnabled = ObservableBoolean(false)
    @Inject
    lateinit var portfolioUseCase: GetPortfolioByIdUseCase

    fun setPortfolioId(id: String) {
        if (portfolioId != null) return
        portfolioId = id
        App.appComponent.inject(this)
        isProgressEnabled.set(true)
        val disposable = portfolioUseCase.getById(id).subscribeBy(
                onNext = {
                    name.set(it.name)
                    articleUrl.set(it.articleUrl)
                },
                onError = {
                    router?.showError(it)
                }
        )
        addToDisposable(disposable)
    }

    private inner class Client : WebViewClient() {
        override fun onReceivedError(view: WebView, request: WebResourceRequest,
                                     error: WebResourceError) {
            super.onReceivedError(view, request, error)
            isProgressEnabled.set(false)
        }

        override fun onPageFinished(view: WebView, url: String) {
            super.onPageFinished(view, url)
            isProgressEnabled.set(false)

        }
    }

    fun getWebViewClient(): WebViewClient {
        isProgressEnabled.set(true)
        return Client()
    }


}
