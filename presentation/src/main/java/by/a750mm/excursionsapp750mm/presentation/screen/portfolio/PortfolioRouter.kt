package by.a750mm.excursionsapp750mm.presentation.screen.portfolio

import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import by.a750mm.excursionsapp750mm.R
import by.a750mm.excursionsapp750mm.presentation.base.BaseRouter
import by.a750mm.excursionsapp750mm.presentation.screen.portfolio.details.PortfolioDetailsFragment
import by.a750mm.excursionsapp750mm.presentation.screen.portfolio.list.PortfolioListFragment
import by.a750mm.excursionsapp750mm.presentation.utils.visibility

class PortfolioRouter(activity: PortfolioActivity) : BaseRouter<PortfolioActivity>(activity) {


    fun goToPortfolioList() {
        replaceFragment(activity.supportFragmentManager, PortfolioListFragment.getInstance(), R.id.container, false)
        val goBackImageButton = activity.findViewById<ImageButton>(R.id.goBackImageButton)
        val titleTextView = activity.findViewById<TextView>(R.id.titleTextView)
        goBackImageButton.visibility(false)
        titleTextView.text = activity.getString(R.string.title_smi)
    }

    fun goToPortfolioDetails(id: String) {
        val containerDetails = activity.findViewById<View>(R.id.containerDetails)
        if (containerDetails == null) {
            replaceFragment(activity.supportFragmentManager, PortfolioDetailsFragment.getInstance(id), R.id.container, true)
        } else {
            replaceFragment(activity.supportFragmentManager, PortfolioDetailsFragment.getInstance(id),
                    R.id.containerDetails, false)
        }
        val goBackImageButton = activity.findViewById<ImageButton>(R.id.goBackImageButton)
        val titleTextView = activity.findViewById<TextView>(R.id.titleTextView)
        goBackImageButton.visibility(true)
        titleTextView.text = activity.getString(R.string.title_smi)
        goBackImageButton.setOnClickListener {
            goToPortfolioList()
        }
    }

}