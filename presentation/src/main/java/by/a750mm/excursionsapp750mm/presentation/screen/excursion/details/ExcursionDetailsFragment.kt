package by.a750mm.excursionsapp750mm.presentation.screen.excursion.details

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil.setContentView
import android.os.Bundle
import android.util.Log
import android.view.View
import by.a750mm.excursionsapp750mm.R
import by.a750mm.excursionsapp750mm.databinding.FragmentExcursionDetailsBinding
import by.a750mm.excursionsapp750mm.presentation.base.BaseMvvmFragment
import by.a750mm.excursionsapp750mm.presentation.screen.excursion.ExcursionRouter
import android.widget.Toast
import by.a750mm.excursionsapp750mm.R.id.mapView
import com.google.android.gms.maps.*
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.LatLng
import by.a750mm.excursionsapp750mm.R.id.mapView
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import by.a750mm.excursionsapp750mm.R.id.mapView


class ExcursionDetailsFragment : BaseMvvmFragment<ExcursionDetailsViewModel, ExcursionRouter, FragmentExcursionDetailsBinding>(),
        OnMapReadyCallback {


    private lateinit var mapView: MapView
    private val gmap: GoogleMap? = null

    private val MAP_VIEW_BUNDLE_KEY = "MapViewBundleKey"

    companion object {
        private const val ID_EXTRA = "ID_EXTRA"
        fun getInstance(id: String): ExcursionDetailsFragment {
            val fragment = ExcursionDetailsFragment()
            val bundle = Bundle()
            bundle.putString(ID_EXTRA, id)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun provideViewModel(): ExcursionDetailsViewModel {
        return ViewModelProviders.of(this).get(ExcursionDetailsViewModel::class.java)
    }

    override fun provideLayoutId(): Int = R.layout.fragment_excursion_details

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = arguments?.getString(ID_EXTRA)
        if (id != null) {
            viewModel.setExcursionId(id)
        } else {
            router?.goBack()
        }
        var mapViewBundle: Bundle? = null
        if (savedInstanceState != null) {
            mapViewBundle = savedInstanceState.getBundle(MAP_VIEW_BUNDLE_KEY)
        }

        mapView = view.findViewById<MapView>(R.id.mapView)
        mapView.onCreate(mapViewBundle)
        mapView.getMapAsync(this)
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onStart() {
        super.onStart()
        mapView.onStart()
    }

    override fun onStop() {
        super.onStop()
        mapView.onStop()
    }

    override fun onPause() {
        mapView.onPause()
        super.onPause()
    }

    override fun onDestroy() {
        mapView.onDestroy()
        super.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }

    override fun onMapReady(googleMap: GoogleMap?) {

    }
}