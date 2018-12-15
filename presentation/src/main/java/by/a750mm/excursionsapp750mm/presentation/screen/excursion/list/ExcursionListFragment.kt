package by.a750mm.excursionsapp750mm.presentation.screen.excursion.list

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil.setContentView
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.TextView
import by.a750mm.excursionsapp750mm.R
import by.a750mm.excursionsapp750mm.databinding.FragmentExcursionListBinding
import by.a750mm.excursionsapp750mm.presentation.base.BaseMvvmFragment
import by.a750mm.excursionsapp750mm.presentation.screen.excursion.ExcursionRouter
import kotlinx.android.synthetic.main.fragment_excursion_list.*


class ExcursionListFragment : BaseMvvmFragment<ExcursionListViewModel, ExcursionRouter, FragmentExcursionListBinding>() {
    companion object {
        fun getInstance(): ExcursionListFragment {
            return ExcursionListFragment()
        }
    }

    override fun provideViewModel(): ExcursionListViewModel {
        return ViewModelProviders.of(this).get(ExcursionListViewModel::class.java)
    }

    override fun provideLayoutId(): Int = R.layout.fragment_excursion_list

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.listRecyclerView.adapter = viewModel.adapter
        binding.listRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.listRecyclerView.setHasFixedSize(true)


    }


    override fun onDestroy() {
        super.onDestroy()
        viewModel.dismissAdapter()
        binding.listRecyclerView.adapter = null
    }

}