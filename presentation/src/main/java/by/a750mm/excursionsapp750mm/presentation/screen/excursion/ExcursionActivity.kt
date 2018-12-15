package by.a750mm.excursionsapp750mm.presentation.screen.excursion

import android.annotation.SuppressLint
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatDelegate
import android.support.v7.widget.PopupMenu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import by.a750mm.excursionsapp750mm.R
import by.a750mm.excursionsapp750mm.databinding.ActivityExcursionBinding
import by.a750mm.excursionsapp750mm.presentation.base.BaseMvvmActivity
import by.a750mm.excursionsapp750mm.presentation.screen.map.MapActivity
import by.a750mm.excursionsapp750mm.presentation.screen.portfolio.PortfolioActivity
import kotlinx.android.synthetic.main.include_bottom_bar.*
import kotlinx.android.synthetic.main.include_top_bar.*


private const val ID_EXTRA = "ID_EXTRA"

class ExcursionActivity : BaseMvvmActivity<ExcursionViewModel, ExcursionRouter, ActivityExcursionBinding>() {


    override fun provideRouter(): ExcursionRouter {
        return ExcursionRouter(this)
    }

    override fun provideViewModel(): ExcursionViewModel {
        return ViewModelProviders.of(this).get(ExcursionViewModel::class.java)
    }

    override fun provideLayoutId(): Int = R.layout.activity_excursion

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_excursion)
        val clickListener = View.OnClickListener { view ->
            when (view.id) {
                R.id.menuImageButton -> {
                    showPopup(view)
                }
            }
        }

        menuImageButton.setOnClickListener(clickListener)


        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        if (intent.getStringExtra(ID_EXTRA) == null) {
            router.goToExcursionList()
        } else {
            router.goToExcursionDetails(intent.getStringExtra(ID_EXTRA))
        }


        val binding: ActivityExcursionBinding = DataBindingUtil.setContentView(this, R.layout.activity_excursion)
        binding.viewModel = ExcursionViewModel()

        buttonList.setBackgroundColor(R.color.colorPrimary)
        buttonList.setOnClickListener {
            val intent = Intent(this, ExcursionActivity::class.java)
            startActivity(intent)
        }
        buttonMap.setOnClickListener {
            val intent = Intent(this, MapActivity::class.java)
            startActivity(intent)
        }
        buttonNews.setOnClickListener {
            val intent = Intent(this, PortfolioActivity::class.java)
            startActivity(intent)
        }

        val titleTextView: TextView = findViewById<TextView>(R.id.titleTextView)
        titleTextView.text = getString(R.string.title_750)
    }

    private fun showPopup(view: View) {
        val popup: PopupMenu?
        popup = PopupMenu(this, view)
        popup.inflate(R.menu.popupmenu)
        popup.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item: MenuItem? ->
            when (item!!.itemId) {
                R.id.menu1 -> {
                    finish()
                    System.exit(0)
                }
            }
            true
        })
        popup.show()
    }

}


