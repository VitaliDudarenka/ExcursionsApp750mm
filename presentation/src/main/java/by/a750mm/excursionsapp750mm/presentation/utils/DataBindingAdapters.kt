package by.a750mm.excursionsapp750mm.presentation.utils

import android.databinding.BindingAdapter
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import com.google.android.gms.maps.model.MarkerOptions
import android.os.Bundle
import android.widget.ImageView
import by.a750mm.excursionsapp750mm.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.MapView
import com.squareup.picasso.Picasso
import by.a750mm.excursionsapp750mm.R.id.mapView
import com.google.android.gms.maps.UiSettings

@BindingAdapter("visibility")
fun View.visibility(visibility: Boolean) {
    this.visibility = if (visibility) View.VISIBLE else View.GONE
}

@BindingAdapter("setWebViewClient")
fun setWebViewClient(view: WebView, client: WebViewClient) {
    view.webViewClient = client
}

@BindingAdapter("loadUrl")
fun loadUrl(view: WebView, url: String) {
    view.loadUrl(url)
}

@BindingAdapter("initMap")
fun initMap(mapView: MapView?, latLng: LatLng) {
    if (mapView != null) {
        mapView.onCreate(Bundle())
        mapView.getMapAsync { googleMap ->
            // Add a marker
            googleMap.addMarker(MarkerOptions().position(latLng).title(""))
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng))
            val uiSettings = googleMap.uiSettings
            uiSettings.isZoomControlsEnabled = true
        }
    }
}

@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, imageUrl: String) {
    if (imageUrl.isEmpty()) return
    Picasso.get()
            .load(imageUrl)
            .fit().error(R.drawable.rails)
            .centerInside()
            .placeholder(R.drawable.progress_animation)
            .into(view)

}