package by.a750mm.excursionsapp750mm.presentation.screen.map

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import by.a750mm.excursionsapp750mm.R
import by.a750mm.excursionsapp750mm.databinding.ActivityMapBinding
import by.a750mm.excursionsapp750mm.presentation.base.BaseMvvmActivity
import by.a750mm.excursionsapp750mm.presentation.screen.excursion.ExcursionActivity
import by.a750mm.excursionsapp750mm.presentation.screen.portfolio.PortfolioActivity
import kotlinx.android.synthetic.main.activity_portfolio.*
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment


class MapActivity : BaseMvvmActivity<MapViewModel, MapRouter, ActivityMapBinding>(), OnMapReadyCallback {


    override fun provideRouter(): MapRouter {
        return MapRouter(this)
    }

    override fun provideViewModel(): MapViewModel {
        return ViewModelProviders.of(this).get(MapViewModel::class.java)
    }

    override fun provideLayoutId(): Int = R.layout.activity_map

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMapBinding = DataBindingUtil.setContentView(this, R.layout.activity_map)
        binding.viewModel = MapViewModel()
        buttonList.setOnClickListener {
            val intent = Intent(this, ExcursionActivity::class.java)
            startActivity(intent)
        }
        buttonNews.setOnClickListener {
            val intent = Intent(this, PortfolioActivity::class.java)
            startActivity(intent)
        }
        val mapFragment: SupportMapFragment? =
                supportFragmentManager.findFragmentById(R.id.mapView) as? SupportMapFragment
        mapFragment?.getMapAsync(this)
    }

    override fun onMapReady(p0: GoogleMap?) {

    }
}


