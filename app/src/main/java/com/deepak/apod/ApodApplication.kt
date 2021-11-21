package com.deepak.apod

import android.app.Application
import com.deepak.apod.di.appComponent
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class ApodApplication :Application(){
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }
    private fun initKoin() {
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@ApodApplication)
            modules(provideDependency())
        }
    }
    private fun provideDependency() = appComponent
}