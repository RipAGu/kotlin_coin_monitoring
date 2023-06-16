package com.example.coin_monitoring.repository

import com.example.coin_monitoring.App
import com.example.coin_monitoring.db.CoinPriceDatabase
import com.example.coin_monitoring.db.entity.InterestCoinEntity

class DBRepository {

    val context = App.context()
    val db = CoinPriceDatabase.getDatabase(context)

    fun getAllInterestCoinData() = db.interestedCoinDao().getAll()

    fun insertInterestCoinData(interestCoinEntity: InterestCoinEntity) = db.interestedCoinDao().insert(interestCoinEntity)

    fun updateInterestCoinData(interestCoinEntity: InterestCoinEntity) = db.interestedCoinDao().update(interestCoinEntity)

    fun getAllInterestSelectedCoinData() = db.interestedCoinDao().getSelectedData()
}