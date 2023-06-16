package com.example.coin_monitoring.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coin_monitoring.MainActivity
import com.example.coin_monitoring.R
import com.example.coin_monitoring.databinding.ActivitySelectBinding
import com.example.coin_monitoring.view.adapter.SelectRVAdapter
import timber.log.Timber

class SelectActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySelectBinding

    private val viewModel : SelectViewModel by viewModels()
    private lateinit var selectRVAdapter: SelectRVAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getCurrentCoinList()
        viewModel.currentPriceResult.observe(this, Observer {

            selectRVAdapter = SelectRVAdapter(this, it)

            binding.coinListRV.adapter = selectRVAdapter
            binding.coinListRV.layoutManager = LinearLayoutManager(this)
            Timber.d(it.toString())
        })

        viewModel.setupFirstFlag()

        binding.laterTextArea.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}