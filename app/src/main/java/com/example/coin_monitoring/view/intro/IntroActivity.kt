package com.example.coin_monitoring.view.intro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.coin_monitoring.R
import timber.log.Timber

class IntroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        installSplashScreen()
        setupTimber()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
    }

    private fun setupTimber() {
        Timber.plant(Timber.DebugTree())
    }
}