package com.example.coin_monitoring.view.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asFlow
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.coin_monitoring.dataModel.UpDownDataSet
import com.example.coin_monitoring.db.entity.InterestCoinEntity
import com.example.coin_monitoring.repository.DBRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val dbRepository = DBRepository()

    lateinit var selectedCoinList : LiveData<List<InterestCoinEntity>>

    // CoinListFragment


    fun getAllInterestCoinData() = viewModelScope.launch {

        val coinList = dbRepository.getAllInterestCoinData().asLiveData()
        selectedCoinList = coinList




    }

    fun updateInterestCoinData(interestCoinEntity: InterestCoinEntity) = viewModelScope.launch(Dispatchers.IO) {

        interestCoinEntity.selected = !interestCoinEntity.selected

        dbRepository.updateInterestCoinData(interestCoinEntity)
    }

    //PriceChangeFragment

    fun getAllSelectedCoinData() = viewModelScope.launch(Dispatchers.IO) {

        //1. 관심있다고 생각한 코인 리스트 가져오기
        val selectedCoinList = dbRepository.getAllInterestSelectedCoinData()

        val arr15min = ArrayList<UpDownDataSet>()
        val arr30min = ArrayList<UpDownDataSet>()
        val arr45min = ArrayList<UpDownDataSet>()

        
        selectedCoinList.collect { list ->
            for (data in list) {
                val coinName = data.coin_name
                val oneCoinData = dbRepository.getOneSelectedCoinData(coinName).reversed()

                val size = oneCoinData.size

                if (size > 1) {

                    val changePrice = oneCoinData[0].price.toDouble() - oneCoinData[1].price.toDouble()
                    val upDownDataSet = UpDownDataSet(
                        coinName,
                        changePrice.toString()
                    )
                    arr15min.add(upDownDataSet)
                }

                if (size > 2) {
                    val changePrice = oneCoinData[0].price.toDouble() - oneCoinData[2].price.toDouble()
                    val upDownDataSet = UpDownDataSet(
                        coinName,
                        changePrice.toString()
                    )
                    arr30min.add(upDownDataSet)


                }

                if (size > 3) {
                    val changePrice = oneCoinData[0].price.toDouble() - oneCoinData[3].price.toDouble()
                    val upDownDataSet = UpDownDataSet(
                        coinName,
                        changePrice.toString()
                    )
                    arr45min.add(upDownDataSet)


                }
            }
        }


    }
}