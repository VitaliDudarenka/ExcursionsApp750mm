package by.a750mm.excursionsapp750mm.presentation.screen.portfolio

import android.view.View
import by.a750mm.excursionsapp750mm.R
import by.a750mm.excursionsapp750mm.presentation.base.BaseRouter
import by.a750mm.excursionsapp750mm.presentation.screen.portfolio.details.PortfolioDetailsFragment
import by.a750mm.excursionsapp750mm.presentation.screen.portfolio.list.PortfolioListFragment

class PortfolioRouter(activity: PortfolioActivity) : BaseRouter<PortfolioActivity>(activity) {
    fun goToPortfolioList() {
        replaceFragment(activity.supportFragmentManager, PortfolioListFragment.getInstance(), R.id.container, false)
    }

    fun goToPortfolioDetails(id: String) {
        val containerDetails = activity.findViewById<View>(R.id.containerDetails)
        if (containerDetails == null) {
            replaceFragment(activity.supportFragmentManager, PortfolioDetailsFragment.getInstance(id), R.id.container, true)
        } else {
            replaceFragment(activity.supportFragmentManager, PortfolioDetailsFragment.getInstance(id),
                    R.id.containerDetails, false)
        }

    }

}