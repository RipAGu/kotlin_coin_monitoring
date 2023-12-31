package com.example.coin_monitoring.view.intro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.Observer
import com.example.coin_monitoring.view.main.MainActivity
import com.example.coin_monitoring.databinding.ActivityIntroBinding

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
                binding.animationView.visibility = View.INVISIBLE
                binding.fragmentContainerView.visibility = View.VISIBLE
                //처음 접속

            }
        })
    }


}