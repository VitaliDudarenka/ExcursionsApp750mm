package by.a750mm.excursionsapp750mm.presentation.inject

import by.a750mm.excursionsapp750mm.presentation.screen.excursion.booking.ExcursionBookingViewModel
import by.a750mm.excursionsapp750mm.presentation.screen.excursion.details.ExcursionDetailsViewModel
import by.a750mm.excursionsapp750mm.presentation.screen.excursion.list.ExcursionListViewModel
import by.a750mm.excursionsapp750mm.presentation.screen.map.MapActivity
import by.a750mm.excursionsapp750mm.presentation.screen.portfolio.details.PortfolioDetailsViewModel
import by.a750mm.excursionsapp750mm.presentation.screen.portfolio.list.PortfolioListViewModel
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(excursionListViewModel: ExcursionListViewModel)
    fun inject(mapActivity: MapActivity)
    fun inject(excursionDetailsViewModel: ExcursionDetailsViewModel)
    fun inject(excursionBookingViewModel: ExcursionBookingViewModel)
    fun inject(portfolioListViewModel: PortfolioListViewModel)
    fun inject(portfolioDetailsViewModel: PortfolioDetailsViewModel)
}