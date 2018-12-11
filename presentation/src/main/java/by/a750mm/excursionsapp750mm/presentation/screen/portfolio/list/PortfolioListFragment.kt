package by.a750mm.excursionsapp750mm.presentation.screen.portfolio.list

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import by.a750mm.excursionsapp750mm.R
import by.a750mm.excursionsapp750mm.databinding.FragmentPortfolioListBinding
import by.a750mm.excursionsapp750mm.presentation.base.BaseMvvmFragment
import by.a750mm.excursionsapp750mm.presentation.screen.portfolio.PortfolioRouter
import kotlinx.android.synthetic.main.fragment_excursion_list.*


class PortfolioListFragment : BaseMvvmFragment<PortfolioListViewModel, PortfolioRouter, FragmentPortfolioListBinding>() {
    companion object {
        fun getInstance(): PortfolioListFragment {
            return PortfolioListFragment()
        }
    }

    override fun provideViewModel(): PortfolioListViewModel {
        return ViewModelProviders.of(this).get(PortfolioListViewModel::class.java)
    }

    override fun provideLayoutId(): Int = R.layout.fragment_portfolio_list

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.listRecyclerView.adapter = viewModel.adapter
        binding.listRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.listRecyclerView.setHasFixedSize(true)

    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.dismissAdapter()
        listRecyclerView.adapter = null
    }

}