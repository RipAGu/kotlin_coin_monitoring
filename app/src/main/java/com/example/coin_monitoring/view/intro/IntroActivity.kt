package com.example.coin_monitoring.view.intro

import android.content.Intent
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.coin_monitoring.MainActivity
import com.example.coin_monitoring.R
import com.example.coin_monitoring.databinding.ActivityIntroBinding
import com.example.coin_monitoring.databinding.ActivitySelectBinding
import timber.log.Timber

class IntroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityIntroBinding

    private val viewModel : IntroViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {

        installSplashScreen()
        super.onCreate(savedInstanceState)
        binding = ActivityIntroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.checkFirstFlag()
        viewModel.first.observe(this, Observer {
            if (it) {
                //기존 유저
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)

            } else {
                binding.fragmentContainerView.visibility = View.VISIBLE
                //처음 접속

            }
        })
    }


}