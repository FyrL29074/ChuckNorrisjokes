package com.fyrl29074.chuck_norris_jokes.app

import android.app.Application
import com.fyrl29074.chuck_norris_jokes.di.appModule
import com.fyrl29074.chuck_norris_jokes.di.dataModule
import com.fyrl29074.chuck_norris_jokes.di.domainModule
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.NONE)
            modules(listOf(appModule, domainModule, dataModule))
        }
    }
}