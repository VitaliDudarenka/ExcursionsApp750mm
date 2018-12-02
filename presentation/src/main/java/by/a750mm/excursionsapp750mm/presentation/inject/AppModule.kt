package by.a750mm.excursionsapp750mm.presentation.inject

import android.content.Context
import by.a750mm.excursionsapp750mm.data.db.AppDataBase
import by.a750mm.excursionsapp750mm.data.db.dao.ExcursionDao
import by.a750mm.excursionsapp750mm.data.net.RestService
import by.a750mm.excursionsapp750mm.data.repositories.ExcursionRepositoryImp
import by.a750mm.excursionsapp750mm.domain.executor.PostExecutorThread
import by.a750mm.excursionsapp750mm.domain.repositories.ExcursionRepository
import by.a750mm.excursionsapp750mm.presentation.executor.UIThread
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class AppModule(val context: Context) {
    @Provides
    //@Singleton
    fun provideContext(): Context {
        return context
    }

    @Provides
    //@Singleton
    fun provideExcursionRepository(restService: RestService, excursionDao: ExcursionDao)
            : ExcursionRepository = ExcursionRepositoryImp(restService, excursionDao)


    @Provides
    //@Singleton
    fun provideExcursionDao(appDataBase: AppDataBase): ExcursionDao = appDataBase.getExcursionDao()


    @Provides
    //@Singleton
    fun provideAppDataBase(context: Context): AppDataBase = AppDataBase.getInstance(context)


    @Provides
    //@Singleton
    fun provideRestService(@Named(URL_INJECT_NAME_DEBUG) serverUrl: String): RestService = RestService(serverUrl)

    @Provides
    //@Singleton
    fun providePostExecutorThread(): PostExecutorThread = UIThread()

    @Provides
    @Named(URL_INJECT_NAME_DEBUG)
    //@Singleton
    fun provideServerUrlDebug(): String = "https://api.backendless.com/CC28C5F9-18E1-C4A3-FFAC-817B1CF20100/2914706F-81A4-0F23-FF63-B8E8C1010A00/data/"

    @Provides
    @Named(URL_INJECT_NAME_RELEASE)
    //@Singleton
    fun provideServerUrlRelease(): String = "https://api.backendless.com/CC28C5F9-18E1-C4A3-FFAC-817B1CF20100/2914706F-81A4-0F23-FF63-B8E8C1010A00/data/"


}