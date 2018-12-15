package by.a750mm.excursionsapp750mm.presentation.screen.map

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.support.v7.widget.PopupMenu
import android.view.MenuItem
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import by.a750mm.excursionsapp750mm.R
import by.a750mm.excursionsapp750mm.domain.entity.Excursion
import by.a750mm.excursionsapp750mm.domain.usecases.GetExcursionUseCase
import by.a750mm.excursionsapp750mm.presentation.app.App
import by.a750mm.excursionsapp750mm.presentation.screen.excursion.ExcursionActivity
import by.a750mm.excursionsapp750mm.presentation.screen.portfolio.PortfolioActivity
import by.a750mm.excursionsapp750mm.presentation.utils.visibility
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.activity_map.*
import kotlinx.android.synthetic.main.include_bottom_bar.*
import kotlinx.android.synthetic.main.include_top_bar.*
import javax.inject.Inject

private const val ID_EXTRA = "ID_EXTRA"

class MapActivity : FragmentActivity(), OnMapReadyCallback, GoogleMap.OnInfoWindowClickListener {
    private var excursionList: List<Excursion> = emptyList()
    private lateinit var mMap: GoogleMap
    @Inject
    lateinit var excursionListUseCase: GetExcursionUseCase
    private val compositeDisposable: CompositeDisposable by lazy {
        CompositeDisposable()
    }

    init {
        App.appComponent.inject(this)
        val disposable = excursionListUseCase.get().subscribeBy(
                onNext = {
                    excursionList = it
                },
                onError = {
                }
        )
        compositeDisposable.add(disposable)
    }


    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)

        val clickListener = View.OnClickListener { view ->
            when (view.id) {
                R.id.menuImageButton -> {
                    showPopup(view)
                }
            }
        }

        menuImageButton.setOnClickListener(clickListener)

        val mapFragment = supportFragmentManager.findFragmentById(R.id.mapView) as? SupportMapFragment
        mapFragment?.getMapAsync(this)

        buttonMap.setBackgroundColor(R.color.colorPrimary)
        buttonList.setOnClickListener {
            val intent = Intent(this, ExcursionActivity::class.java)
            startActivity(intent)
        }
        buttonNews.setOnClickListener {
            val intent = Intent(this, PortfolioActivity::class.java)
            startActivity(intent)
        }
        val goBackImageButton = findViewById<ImageButton>(R.id.goBackImageButton)
        val titleTextView = findViewById<TextView>(R.id.titleTextView)
        goBackImageButton.visibility(false)
        titleTextView.text = getString(R.string.title_750)

    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        mMap.setOnMapLoadedCallback {
            val builder = LatLngBounds.Builder()
            for (excursion in excursionList) {
                val latLng = (excursion.location).split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
                val latitude = java.lang.Double.parseDouble(latLng[0])
                val longitude = java.lang.Double.parseDouble(latLng[1])
                var markerColor = BitmapDescriptorFactory.HUE_RED
                if (excursion.seatsRest > 0) {
                    markerColor = BitmapDescriptorFactory.HUE_GREEN
                }
                val marker = mMap.addMarker(MarkerOptions().position(LatLng(latitude, longitude)).title(excursion.name)
                        .snippet(getString(R.string.seatsValue) + " " + excursion.seatsRest)
                        .icon(BitmapDescriptorFactory.defaultMarker(markerColor)))
                marker.tag = excursion.id
                builder.include(marker.position)
            }
            val bounds = builder.build()
            val cameraUpdate = CameraUpdateFactory.newLatLngBounds(bounds, 120)
            mMap.animateCamera(cameraUpdate)
            mMap.setOnInfoWindowClickListener(this)
        }
    }

    override fun onInfoWindowClick(marker: Marker) {
        val intent = Intent(this, ExcursionActivity::class.java)
        intent.putExtra(ID_EXTRA, marker.tag.toString())
        startActivity(intent)
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


