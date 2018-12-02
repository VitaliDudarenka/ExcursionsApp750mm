package by.a750mm.excursionsapp750mm.presentation.screen.excursion.booking

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.View
import by.a750mm.excursionsapp750mm.R
import by.a750mm.excursionsapp750mm.databinding.FragmentExcursionBookingBinding
import by.a750mm.excursionsapp750mm.presentation.base.BaseMvvmFragment
import by.a750mm.excursionsapp750mm.presentation.screen.excursion.ExcursionRouter

class ExcursionBookingFragment : BaseMvvmFragment<ExcursionBookingViewModel, ExcursionRouter, FragmentExcursionBookingBinding>() {
    companion object {
        private const val ID_EXTRA = "ID_EXTRA"
        fun getInstance(id: String): ExcursionBookingFragment {
            val fragment = ExcursionBookingFragment()
            val bundle = Bundle()
            bundle.putString(ID_EXTRA, id)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun provideViewModel(): ExcursionBookingViewModel {
        return ViewModelProviders.of(this).get(ExcursionBookingViewModel::class.java)
    }

    override fun provideLayoutId(): Int = R.layout.fragment_excursion_booking

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