package com.kashapovrush.composeapp

import android.app.Application
import di.getSharedModule
import org.koin.core.context.startKoin
import org.koin.dsl.koinApplication
import org.koin.dsl.module

class ApplicationRepo: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin { modules(getSharedModule()) }
    }
}
