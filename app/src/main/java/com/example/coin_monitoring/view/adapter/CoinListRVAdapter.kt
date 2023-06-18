package com.example.coin_monitoring.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coin_monitoring.R
import com.example.coin_monitoring.db.entity.InterestCoinEntity

class CoinListRVAdapter(val context : Context, val dataSet : List<InterestCoinEntity>)
    : RecyclerView.Adapter<CoinListRVAdapter.ViewHolder>() {


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.main_coin_item, parent, false)

        return ViewHolder(view)
    }

    //
    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    }


}