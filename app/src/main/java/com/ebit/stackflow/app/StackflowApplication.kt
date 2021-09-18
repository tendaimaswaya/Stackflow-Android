package com.ebit.stackflow.app

import android.app.Application
import com.ebit.stackflow.di.apiModule
import com.ebit.stackflow.di.repositoryModule
import com.ebit.stackflow.di.retrofitModule
import com.ebit.stackflow.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class StackflowApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@StackflowApplication)
            modules(listOf(repositoryModule, viewModelModule, retrofitModule, apiModule))
        }
    }
}