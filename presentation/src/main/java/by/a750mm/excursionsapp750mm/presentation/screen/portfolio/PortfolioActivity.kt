package by.a750mm.excursionsapp750mm.presentation.screen.portfolio

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import by.a750mm.excursionsapp750mm.presentation.base.BaseMvvmActivity
import android.databinding.DataBindingUtil
import by.a750mm.excursionsapp750mm.R
import by.a750mm.excursionsapp750mm.databinding.ActivityExcursionBinding
import by.a750mm.excursionsapp750mm.databinding.ActivityPortfolioBinding
import by.a750mm.excursionsapp750mm.presentation.screen.excursion.ExcursionActivity
import by.a750mm.excursionsapp750mm.presentation.screen.excursion.ExcursionRouter
import by.a750mm.excursionsapp750mm.presentation.screen.excursion.ExcursionViewModel
import by.a750mm.excursionsapp750mm.presentation.screen.map.MapActivity
import kotlinx.android.synthetic.main.activity_portfolio.*


class PortfolioActivity : BaseMvvmActivity<PortfolioViewModel, PortfolioRouter, ActivityPortfolioBinding>() {
    override fun provideRouter(): PortfolioRouter {
        return PortfolioRouter(this)
    }

    override fun provideViewModel(): PortfolioViewModel {
        return ViewModelProviders.of(this).get(PortfolioViewModel::class.java)
    }

    override fun provideLayoutId(): Int = R.layout.activity_portfolio

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null)
            router.goToPortfolioList()
        val binding: ActivityPortfolioBinding = DataBindingUtil.setContentView(this, R.layout.activity_portfolio)
        binding.viewModel = PortfolioViewModel()
        buttonList.setOnClickListener {
            val intent = Intent(this, ExcursionActivity::class.java)
            startActivity(intent)
        }
        buttonMap.setOnClickListener {
            val intent = Intent(this, MapActivity::class.java)
            startActivity(intent)
        }
    }



}