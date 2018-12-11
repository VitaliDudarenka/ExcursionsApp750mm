package by.a750mm.excursionsapp750mm.presentation.screen.excursion.details

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil.setContentView
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
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
import by.a750mm.excursionsapp750mm.presentation.screen.portfolio.PortfolioActivity
import by.a750mm.excursionsapp750mm.presentation.utils.visibility
import kotlinx.android.synthetic.main.activity_excursion.*


class ExcursionDetailsFragment : BaseMvvmFragment<ExcursionDetailsViewModel, ExcursionRouter, FragmentExcursionDetailsBinding>() {


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

    }

}