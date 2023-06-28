package com.example.coin_monitoring.repository

import com.example.coin_monitoring.App
import com.example.coin_monitoring.db.CoinPriceDatabase
import com.example.coin_monitoring.db.entity.InterestCoinEntity
import com.example.coin_monitoring.db.entity.SelectedCoinPriceEntity

class DBRepository {

    val context = App.context()
    val db = CoinPriceDatabase.getDatabase(context)

    fun getAllInterestCoinData() = db.interestedCoinDao().getAll()

    fun insertInterestCoinData(interestCoinEntity: InterestCoinEntity) = db.interestedCoinDao().insert(interestCoinEntity)

    fun updateInterestCoinData(interestCoinEntity: InterestCoinEntity) = db.interestedCoinDao().update(interestCoinEntity)

    fun getAllInterestSelectedCoinData() = db.interestedCoinDao().getSelectedData()

    fun getAllCoinPriceData() = db.selectedCoinDAO().getAllData()

    fun insertCoinPriceData(selectedCoinPriceEntity: SelectedCoinPriceEntity) = db.selectedCoinDAO().insert(selectedCoinPriceEntity)

    fun getOneSelectedCoinData(coinName : String) = db.selectedCoinDAO().getOneCoinData(coinName)

}