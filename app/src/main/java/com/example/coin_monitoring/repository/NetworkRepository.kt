package com.example.coin_monitoring.repository

import com.example.coin_monitoring.network.Api
import com.example.coin_monitoring.network.RetrofitInstance
import retrofit2.Retrofit

class NetworkRepository {

    private val client = RetrofitInstance.getInstance().create(Api::class.java)

    suspend fun getCurrentCoinList() = client.getCurrentCoinList()

    suspend fun getInterestCoinPriceData(coin : String) = client.getRecentCoinPrice(coin)
}