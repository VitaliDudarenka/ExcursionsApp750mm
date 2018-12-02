package by.a750mm.excursionsapp750mm.presentation.inject

import by.a750mm.excursionsapp750mm.presentation.screen.excursion.list.ExcursionListViewModel
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(excursionListViewModel: ExcursionListViewModel)
}