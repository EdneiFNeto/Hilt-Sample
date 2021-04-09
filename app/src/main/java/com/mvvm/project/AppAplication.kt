package com.mvvm.project

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import com.mvvm.project.di.modules.*

class AppAplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@AppAplication)
            modules(
                listOf(
                    databaseModule,
                    daoModule,
                    webClienteModele,
                    repositoryModule,
                    viewModelModule
                )
            )
        }
    }
}