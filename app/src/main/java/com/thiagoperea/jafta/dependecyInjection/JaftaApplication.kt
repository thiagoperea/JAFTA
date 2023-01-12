package com.thiagoperea.jafta.dependecyInjection

import android.app.Application
import com.thiagoperea.jafta.login.dependencyInjection.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class JaftaApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@JaftaApplication)

            // Load modules
            modules(
                viewModelModule
            )
        }
    }
}
