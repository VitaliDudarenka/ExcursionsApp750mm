package by.a750mm.excursionsapp750mm.presentation.screen.portfolio

import android.annotation.SuppressLint
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.content.pm.ActivityInfo
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.PopupMenu
import android.widget.TextView
import by.a750mm.excursionsapp750mm.R
import by.a750mm.excursionsapp750mm.databinding.ActivityPortfolioBinding
import by.a750mm.excursionsapp750mm.presentation.base.BaseMvvmActivity
import by.a750mm.excursionsapp750mm.presentation.screen.excursion.ExcursionActivity
import by.a750mm.excursionsapp750mm.presentation.screen.map.MapActivity
import kotlinx.android.synthetic.main.include_bottom_bar.*


class PortfolioActivity : BaseMvvmActivity<PortfolioViewModel, PortfolioRouter, ActivityPortfolioBinding>() {
    override fun provideRouter(): PortfolioRouter {
        return PortfolioRouter(this)
    }

    override fun provideViewModel(): PortfolioViewModel {
        return ViewModelProviders.of(this).get(PortfolioViewModel::class.java)
    }

    override fun provideLayoutId(): Int = R.layout.activity_portfolio

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        if (savedInstanceState == null)
            router.goToPortfolioList()
        val binding: ActivityPortfolioBinding = DataBindingUtil.setContentView(this, R.layout.activity_portfolio)
        binding.viewModel = PortfolioViewModel()

        val menuButton = findViewById<ImageButton>(R.id.menuImageButton)
        menuButton.setOnClickListener {
            Log.e("AAA", "click")
            val popupMenu: android.widget.PopupMenu = android.widget.PopupMenu(this, menuButton)
            popupMenu.menuInflater.inflate(R.menu.popupmenu, popupMenu.menu)
            popupMenu.setOnMenuItemClickListener(android.widget.PopupMenu.OnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.menu1 -> {
                        finish()
                        System.exit(0)
                    }
                }
                true
            })
            popupMenu.show()
        }
        buttonNews.setBackgroundColor(R.color.colorPrimary)
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

        val titleTextView = findViewById<TextView>(R.id.titleTextView)
        titleTextView.text = getString(R.string.title_smi)
    }

}