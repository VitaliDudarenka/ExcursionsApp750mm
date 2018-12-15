package by.a750mm.excursionsapp750mm.presentation.app

import android.app.Application
import by.a750mm.excursionsapp750mm.presentation.inject.AppComponent
import by.a750mm.excursionsapp750mm.presentation.inject.AppModule
import by.a750mm.excursionsapp750mm.presentation.inject.DaggerAppComponent
import com.crashlytics.android.Crashlytics
import com.google.android.gms.maps.MapsInitializer
import com.squareup.leakcanary.LeakCanary
import io.fabric.sdk.android.Fabric


class App : Application() {
    companion object {
        lateinit var instance: App
        @JvmStatic
        lateinit var appComponent: AppComponent
    }

    init {
        instance = this
    }

    override fun onCreate() {
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
        super.onCreate()
        Fabric.with(this, Crashlytics())
        MapsInitializer.initialize(this)
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return
        }
        LeakCanary.install(this)

    }
}