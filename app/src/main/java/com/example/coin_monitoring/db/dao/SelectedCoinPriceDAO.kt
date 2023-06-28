package com.example.coin_monitoring.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.coin_monitoring.db.entity.SelectedCoinPriceEntity


@Dao
interface SelectedCoinPriceDAO {

    //전체 데이터 가져오기
    @Query("SELECT * FROM selected_coin_price_table")
    fun getAllData() : List<SelectedCoinPriceEntity>


    //데이터 저장
    @Insert
    fun insert(selectedCoinPriceEntity : SelectedCoinPriceEntity)


    //하나의 코인의 저장된 정보 가져오기
    @Query("SELECT * FROM selected_coin_price_table WHERE coinName = :coinName")
    fun getOneCoinData(coinName : String) : List<SelectedCoinPriceEntity>
}