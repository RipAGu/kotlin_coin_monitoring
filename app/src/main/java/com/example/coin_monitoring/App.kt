package com.example.coin_monitoring

import android.app.Application
import android.content.Context
import timber.log.Timber

class App : Application() {

    init {
        instance = this
        setupTimber()

    }
    companion object {
        private var instance : App? = null

        fun context() : Context {
            return instance!!.applicationContext
        }
    }

    private fun setupTimber() {
        Timber.plant(Timber.DebugTree())
    }
}