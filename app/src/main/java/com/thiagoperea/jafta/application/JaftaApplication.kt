package com.thiagoperea.jafta.application

import android.app.Application
import com.thiagoperea.jafta.login.di.loginModule
import com.thiagoperea.jafta.transaction.di.transactionModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

const val APP_TAG = "TAG.JAFTA"

class JaftaApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@JaftaApplication)

            // Load modules
            modules(
                loginModule,
                transactionModule
            )
        }
    }
}
