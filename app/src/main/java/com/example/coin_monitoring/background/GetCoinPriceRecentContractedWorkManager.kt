package com.example.coin_monitoring.background

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters

//최근 코인 거래내역 가져오기

class GetCoinPriceRecentContractedWorkManager(val context : Context, workerParameters: WorkerParameters) : CoroutineWorker(context, workerParameters) {

    override suspend fun doWork(): Result {

        return Result.success()
    }



}