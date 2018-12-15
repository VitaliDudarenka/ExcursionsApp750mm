package by.a750mm.excursionsapp750mm.presentation.screen.portfolio.details

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import by.a750mm.excursionsapp750mm.R
import by.a750mm.excursionsapp750mm.databinding.FragmentPortfolioDetailsBinding
import by.a750mm.excursionsapp750mm.presentation.base.BaseMvvmFragment
import by.a750mm.excursionsapp750mm.presentation.screen.portfolio.PortfolioRouter


class PortfolioDetailsFragment : BaseMvvmFragment<PortfolioDetailsViewModel, PortfolioRouter, FragmentPortfolioDetailsBinding>() {
    lateinit var myWebView: WebView

    companion object {
        private const val ID_EXTRA = "ID_EXTRA"
        fun getInstance(id: String): PortfolioDetailsFragment {
            val fragment = PortfolioDetailsFragment()
            val bundle = Bundle()
            bundle.putString(ID_EXTRA, id)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun provideViewModel(): PortfolioDetailsViewModel {
        return ViewModelProviders.of(this).get(PortfolioDetailsViewModel::class.java)
    }

    override fun provideLayoutId(): Int = R.layout.fragment_portfolio_details

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = arguments?.getString(ID_EXTRA)
        if (id != null) {
            viewModel.setPortfolioId(id)
        } else {
            router?.goBack()
        }
        myWebView = view.findViewById(R.id.webView)
    }


    override fun onDestroy() {
        super.onDestroy()
        myWebView.destroy()
    }

    override fun onStop() {
        super.onStop()
        myWebView.stopLoading()
    }

    override fun onPause() {
        super.onPause()
        myWebView.pauseTimers()
    }


}