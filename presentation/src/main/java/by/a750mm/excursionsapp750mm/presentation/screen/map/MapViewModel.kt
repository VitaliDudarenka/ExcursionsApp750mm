package by.a750mm.excursionsapp750mm.presentation.screen.map

import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import by.a750mm.excursionsapp750mm.presentation.base.BaseViewModel
import by.a750mm.excursionsapp750mm.presentation.screen.excursion.ExcursionRouter
import com.google.android.gms.maps.model.LatLng


class MapViewModel : BaseViewModel<MapRouter>() {
    var mMapLatLng = ObservableField<LatLng>(LatLng(53.9027, 27.5616))
}