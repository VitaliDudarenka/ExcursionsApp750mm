package by.a750mm.excursionsapp750mm.presentation.screen.portfolio.details

import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import by.a750mm.excursionsapp750mm.presentation.base.BaseViewModel
import by.a750mm.excursionsapp750mm.presentation.factory.UseCaseProvider
import by.a750mm.excursionsapp750mm.presentation.screen.portfolio.PortfolioRouter
import io.reactivex.rxkotlin.subscribeBy
import android.databinding.Bindable
import android.webkit.WebViewClient
import android.webkit.WebView
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest


class PortfolioDetailsViewModel : BaseViewModel<PortfolioRouter>() {
    val name = ObservableField<String>(" ")
    val articleUrl = ObservableField<String>(" ")
    private var portfolioId: String? = null
    private val portfolioUseCase = UseCaseProvider.providePortfolioUseCase()
    val isProgressEnabled = ObservableBoolean(false)

    fun setPortfolioId(id: String) {
        if (portfolioId != null) return
        portfolioId = id
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
