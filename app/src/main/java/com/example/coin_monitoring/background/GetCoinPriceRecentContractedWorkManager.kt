package com.example.coin_monitoring.background

import android.content.Context
import android.net.Network
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.coin_monitoring.db.entity.SelectedCoinPriceEntity
import com.example.coin_monitoring.network.model.RecentCoinPriceList
import com.example.coin_monitoring.repository.DBRepository
import com.example.coin_monitoring.repository.NetworkRepository
import kotlinx.coroutines.flow.collect
import timber.log.Timber
import java.util.Calendar
import java.util.Date

//최근 코인 거래내역 가져오기

class GetCoinPriceRecentContractedWorkManager(val context : Context, workerParameters: WorkerParameters) : CoroutineWorker(context, workerParameters) {

    private val dbRepository = DBRepository()
    private val networkRepository = NetworkRepository()

    override suspend fun doWork(): Result {

        getAllInterestSelectedCoinData()

        return Result.success()
    }

    // 1. 관심 목록 클릭한 코인 리스트 가져오기
    suspend fun getAllInterestSelectedCoinData() {
        val selectedCoinList = dbRepository.getAllInterestSelectedCoinData()

        val timeStamp = Calendar.getInstance().time

        dbRepository.getAllInterestSelectedCoinData().collect { selectedCoinList ->
            for (coinData in selectedCoinList) {
                Log.d("selectedCoinList", coinData.toString())

                val recentCoinPriceList = networkRepository.getInterestCoinPriceData(coinData.coin_name)
            }
        }
    }

    fun saveSelectedCoinPrice(
        coinName : String,
        recentCoinPriceList : RecentCoinPriceList,
        timeStamp : Date
    ) {
        val selectedCoinPriceEntity = SelectedCoinPriceEntity(
            0,
            coinName,
            recentCoinPriceList.data[0].transaction_data,
            recentCoinPriceList.data[0].type,
            recentCoinPriceList.data[0].units_traded,
            recentCoinPriceList.data[0].price,
            recentCoinPriceList.data[0].total,
            timeStamp


        )

        dbRepository.insertCoinPriceData(selectedCoinPriceEntity)
    }



}