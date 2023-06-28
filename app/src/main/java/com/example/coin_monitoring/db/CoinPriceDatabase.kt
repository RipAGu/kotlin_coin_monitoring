package com.example.coin_monitoring.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.coin_monitoring.db.dao.InterestCoinDao
import com.example.coin_monitoring.db.dao.SelectedCoinPriceDAO
import com.example.coin_monitoring.db.entity.DataConverters
import com.example.coin_monitoring.db.entity.InterestCoinEntity
import com.example.coin_monitoring.db.entity.SelectedCoinPriceEntity


@Database(entities = [InterestCoinEntity::class, SelectedCoinPriceEntity::class], version = 2)
@TypeConverters(DataConverters::class)
abstract class CoinPriceDatabase : RoomDatabase() {

    abstract fun interestedCoinDao() : InterestCoinDao
    abstract fun selectedCoinDAO() : SelectedCoinPriceDAO

    companion object {

        @Volatile
        private var INSTANCE : CoinPriceDatabase? = null

        fun getDatabase(
            context: Context
        ) : CoinPriceDatabase{
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CoinPriceDatabase::class.java,
                    "coin_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }


}