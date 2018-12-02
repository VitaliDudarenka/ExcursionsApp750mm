package by.a750mm.excursionsapp750mm.presentation.screen.excursion

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import by.a750mm.excursionsapp750mm.presentation.base.BaseMvvmActivity
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatDelegate
import android.support.v7.widget.Toolbar
import android.widget.Toast
import by.a750mm.excursionsapp750mm.R
import by.a750mm.excursionsapp750mm.databinding.ActivityExcursionBinding
import by.a750mm.excursionsapp750mm.presentation.screen.map.MapActivity
import by.a750mm.excursionsapp750mm.presentation.screen.portfolio.PortfolioActivity
import kotlinx.android.synthetic.main.activity_excursion.*
import kotlinx.android.synthetic.main.activity_portfolio.*


class ExcursionActivity : BaseMvvmActivity<ExcursionViewModel, ExcursionRouter, ActivityExcursionBinding>() {
    override fun provideRouter(): ExcursionRouter {
        return ExcursionRouter(this)
    }

    override fun provideViewModel(): ExcursionViewModel {
        return ViewModelProviders.of(this).get(ExcursionViewModel::class.java)
    }

    override fun provideLayoutId(): Int = R.layout.activity_excursion

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        if (savedInstanceState == null)
            router.goToExcursionList()
        val binding: ActivityExcursionBinding = DataBindingUtil.setContentView(this, R.layout.activity_excursion)
        binding.viewModel = ExcursionViewModel()
        buttonMapE.setOnClickListener {
            val intent = Intent(this, MapActivity::class.java)
            startActivity(intent)
        }
        buttonNewsE.setOnClickListener {
            val intent = Intent(this, PortfolioActivity::class.java)
            startActivity(intent)
        }
    }


}