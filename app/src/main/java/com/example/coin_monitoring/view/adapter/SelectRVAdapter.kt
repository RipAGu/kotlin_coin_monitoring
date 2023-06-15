package com.example.coin_monitoring.view.adapter

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.coin_monitoring.R
import com.example.coin_monitoring.dataModel.CurrentPriceResult
import org.w3c.dom.Text

class SelectRVAdapter(val context : Context, val coinPriceList : List<CurrentPriceResult>)
    : RecyclerView.Adapter<SelectRVAdapter.ViewHolder>(){

        inner class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
            val coinName : TextView = view.findViewById(R.id.coinName)
            val coinPriceUpDown : TextView = view.findViewById(R.id.coinPriceUpDown)
            val likeImage : ImageView = view.findViewById(R.id.likeBtn)


        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.intro_coin_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return coinPriceList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.coinName.text = coinPriceList[position].coinName

        val fluctate_24H = coinPriceList[position].coinInfo.fluctate_24H

        if (fluctate_24H.contains("-")) {
            holder.coinPriceUpDown.text = "하락입니다."
            holder.coinPriceUpDown.setTextColor(Color.parseColor("#114fed"))
        } else {
            holder.coinPriceUpDown.text = "상승입니다."
            holder.coinPriceUpDown.setTextColor(Color.parseColor("#ed2e11"))
        }

        val likeImage = holder.likeImage

        likeImage.setOnClickListener{
            likeImage.setImageResource(R.drawable.like_red)
        }
    }

}