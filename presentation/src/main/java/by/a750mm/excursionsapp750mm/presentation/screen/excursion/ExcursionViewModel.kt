package by.a750mm.excursionsapp750mm.presentation.screen.excursion

import android.content.Intent
import android.databinding.ObservableBoolean
import android.support.v4.content.ContextCompat.startActivity
import by.a750mm.excursionsapp750mm.presentation.base.BaseViewModel
import by.a750mm.excursionsapp750mm.presentation.screen.map.MapActivity


class ExcursionViewModel : BaseViewModel<ExcursionRouter>() {
    val isBackButtonEnabled = ObservableBoolean(true)
}