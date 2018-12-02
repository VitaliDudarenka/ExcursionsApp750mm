package by.a750mm.excursionsapp750mm.presentation.screen.excursion

import android.content.Intent
import android.support.v4.content.ContextCompat
import android.support.v4.content.ContextCompat.startActivity
import android.view.View
import android.widget.Toast
import by.a750mm.excursionsapp750mm.R
import by.a750mm.excursionsapp750mm.presentation.base.BaseRouter
import by.a750mm.excursionsapp750mm.presentation.screen.excursion.booking.ExcursionBookingFragment
import by.a750mm.excursionsapp750mm.presentation.screen.excursion.details.ExcursionDetailsFragment
import by.a750mm.excursionsapp750mm.presentation.screen.excursion.list.ExcursionListFragment
import by.a750mm.excursionsapp750mm.presentation.screen.map.MapActivity

class ExcursionRouter(activity: ExcursionActivity) : BaseRouter<ExcursionActivity>(activity) {
    fun goToExcursionList() {
        replaceFragment(activity.supportFragmentManager, ExcursionListFragment.getInstance(), R.id.container, false)
    }

    fun goToExcursionDetails(id: String) {
        val containerDetails = activity.findViewById<View>(R.id.containerDetails)
        if (containerDetails == null) {
            replaceFragment(activity.supportFragmentManager, ExcursionDetailsFragment.getInstance(id), R.id.container, true)
        } else {
            replaceFragment(activity.supportFragmentManager, ExcursionDetailsFragment.getInstance(id),
                    R.id.containerDetails, false)
        }

    }

    fun goToExcursionBooking(id: String) {
        val containerDetails = activity.findViewById<View>(R.id.containerDetails)
        if (containerDetails == null) {
            replaceFragment(activity.supportFragmentManager, ExcursionBookingFragment.getInstance(id), R.id.container, true)
        } else {
            replaceFragment(activity.supportFragmentManager, ExcursionBookingFragment.getInstance(id),
                    R.id.containerDetails, false)
        }
    }

    fun showBookingComplete() {
        Toast.makeText(activity, "Бронь принята. Ожидайте подтверждение.", Toast.LENGTH_SHORT).show()
    }

    fun showBookingError() {
        Toast.makeText(activity, "Заполните обязательные поля формы.", Toast.LENGTH_SHORT).show()
    }

    fun showSeatsError() {
        Toast.makeText(activity, "Превышено количство мест.", Toast.LENGTH_SHORT).show()
    }



}