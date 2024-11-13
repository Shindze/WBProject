package com.shindze.wbschoolproject.di

import android.app.Application
import com.shindze.domain.di.DomainModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    presentationModules, DomainModules
                )
            )
        }
    }
}
