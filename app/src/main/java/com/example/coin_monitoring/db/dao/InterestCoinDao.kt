package com.example.coin_monitoring.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.coin_monitoring.db.entity.InterestCoinEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface InterestCoinDao {

    @Query("SELECT * FROM interest_coin_table")
    fun getAll() : Flow<List<InterestCoinEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert (interestCoinEntity: InterestCoinEntity)

    @Update
    fun update (interestCoinEntity: InterestCoinEntity)

    @Query("SELECT * FROM interest_coin_table WHERE selected = :selected")
    fun getSelectedData(selected : Boolean = true) : Flow<List<InterestCoinEntity>>

}