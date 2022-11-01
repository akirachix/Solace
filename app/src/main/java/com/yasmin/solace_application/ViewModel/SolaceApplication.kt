package com.yasmin.solace_application.ViewModel

import android.app.Application
import android.content.Context

class SolaceApplication: Application() {
    companion object{
        lateinit var appContext : Context
    }
    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
    }
}