package com.example.android.littlelottery

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_lottery.view.*

//實作一個Adapter給RecyclerView用
class LotteryAdapter: RecyclerView.Adapter<LotteryAdapter.TextItemViewHolder>(){
    var data = MutableList<Int>(10){it+11}
        set(value) {
            field = value
            //告訴RecyclerView項目已更新
            notifyDataSetChanged()
        }

    //給定項目數量
    override fun getItemCount() = data.size
    //override fun getItemCount() = 1

    //替換 ViewHolder 的內容
    override fun onBindViewHolder(holder: TextItemViewHolder, position: Int) {
        val item = data[position]
        //val item = data
        Log.i("LotteryAdapter", "替換data")
        holder.textView.text = item.toString()
    }

    //創建ViewHolder，作為RecyclerView的容器
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextItemViewHolder {
        //設定在父層級將的充氣者
        val layoutInflater = LayoutInflater.from(parent.context)

        // 對新的 view 充氣
        //這邊的第一個參數是ViewHolder的外觀，需定義在layout檔中
        val view = layoutInflater
            .inflate(R.layout.text_item_view, parent, false) as TextView

        //回傳ViewHolder
        return TextItemViewHolder(view)
    }

    class TextItemViewHolder(val textView: TextView): RecyclerView.ViewHolder(textView)

}