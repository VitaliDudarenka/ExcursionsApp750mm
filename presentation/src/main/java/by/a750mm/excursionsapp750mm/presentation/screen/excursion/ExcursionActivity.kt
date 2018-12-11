package by.a750mm.excursionsapp750mm.presentation.screen.excursion

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatDelegate
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import by.a750mm.excursionsapp750mm.R
import by.a750mm.excursionsapp750mm.databinding.ActivityExcursionBinding
import by.a750mm.excursionsapp750mm.presentation.base.BaseMvvmActivity
import by.a750mm.excursionsapp750mm.presentation.screen.map.MapActivity
import by.a750mm.excursionsapp750mm.presentation.screen.portfolio.PortfolioActivity
import by.a750mm.excursionsapp750mm.presentation.utils.visibility
import kotlinx.android.synthetic.main.activity_excursion.*


private const val ID_EXTRA = "ID_EXTRA"

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
        if (intent.getStringExtra(ID_EXTRA) == null) {
            router.goToExcursionList()
        } else {
            router.goToExcursionDetails(intent.getStringExtra(ID_EXTRA))
        }


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

        val titleTextView: TextView = findViewById<TextView>(R.id.titleTextView)
        titleTextView.text = "750MM.BY"
    }


}