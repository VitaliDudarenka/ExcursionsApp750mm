package by.a750mm.excursionsapp750mm.presentation.inject

import by.a750mm.excursionsapp750mm.presentation.screen.excursion.list.ExcursionListViewModel
import by.a750mm.excursionsapp750mm.presentation.screen.map.MapActivity
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(excursionListViewModel: ExcursionListViewModel)
    fun inject(mapActivity: MapActivity)
}