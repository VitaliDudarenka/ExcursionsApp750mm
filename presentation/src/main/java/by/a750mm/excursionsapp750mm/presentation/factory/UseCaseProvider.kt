package by.a750mm.excursionsapp750mm.presentation.factory

import by.a750mm.excursionsapp750mm.data.db.AppDataBase
import by.a750mm.excursionsapp750mm.data.net.RestService
import by.a750mm.excursionsapp750mm.data.repositories.BookingRepositoryImp
import by.a750mm.excursionsapp750mm.data.repositories.ExcursionRepositoryImp
import by.a750mm.excursionsapp750mm.data.repositories.PortfolioRepositoryImp
import by.a750mm.excursionsapp750mm.domain.usecases.*
import by.a750mm.excursionsapp750mm.presentation.app.App
import by.a750mm.excursionsapp750mm.presentation.executor.UIThread

object UseCaseProvider {
    val uiThread = UIThread()
    val restService = RestService("https://api.backendless.com/CC28C5F9-18E1-C4A3-FFAC-817B1CF20100/2914706F-81A4-0F23-FF63-B8E8C1010A00/data/")
    fun provideExcursionListUseCase(): GetExcursionUseCase {
        val excursionDao = AppDataBase.getInstance(App.instance.applicationContext).getExcursionDao()
        val repository = ExcursionRepositoryImp(restService, excursionDao)
        return GetExcursionUseCase(uiThread, repository)
    }

    fun provideExcursionUseCase(): GetByIdUseCase {
        val excursionDao = AppDataBase.getInstance(App.instance.applicationContext).getExcursionDao()
        return GetByIdUseCase(uiThread, ExcursionRepositoryImp(restService, excursionDao))
    }

    fun provideAddBookingUseCase(): AddBookingUseCase {
        return AddBookingUseCase(uiThread, BookingRepositoryImp(restService))
    }

    fun providePortfolioListUseCase(): GetPortfolioUseCase {
        val portfolioDao = AppDataBase.getInstance(App.instance.applicationContext).getPortfolioDao()
        val repository = PortfolioRepositoryImp(restService, portfolioDao)
        return GetPortfolioUseCase(uiThread, repository)
    }

    fun providePortfolioUseCase(): GetPortfolioByIdUseCase {
        val portfolioDao = AppDataBase.getInstance(App.instance.applicationContext).getPortfolioDao()
        return GetPortfolioByIdUseCase(uiThread, PortfolioRepositoryImp(restService, portfolioDao))
    }
}