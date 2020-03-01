package com.crp.restofinder

import android.app.Application
import com.crp.restofinder.di.appModule
import com.crp.restofinder.di.networkModule
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class RestoApp : Application() {

    val defaultCurrentActivityListener: DefaultCurrentActivityListener by inject()
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@RestoApp)
            modules(listOf(networkModule, appModule))
        }
        registerActivityLifecycleCallbacks(defaultCurrentActivityListener)

    }
}