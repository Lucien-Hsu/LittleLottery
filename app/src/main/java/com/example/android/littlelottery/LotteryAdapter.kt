package com.example.android.littlelottery

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListAdapter
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_lottery.view.*

//實作一個Adapter給RecyclerView用
class LotteryAdapter(var myData: MutableList<LotteryType>): RecyclerView.Adapter<LotteryAdapter.ViewHolder>(){
//class LotteryAdapter: ListAdapter<LotteryType, >(LotteryDiffCallback()){
    var data = myData
        set(value) {
            field = value
            //告訴RecyclerView項目已更新
            notifyDataSetChanged()
        }

    //給定項目數量
    override fun getItemCount() = data.size

    //創建RecyclerView容器
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    //替換 ViewHolder 的內容
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
//        val item = getItem(position)
        Log.i("LotteryAdapter", "onBindViewHolder 綁定資料")

        //把項目內容給ViewHolder處理
        holder.bind(item)
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var tv_typeInput: TextView = itemView.findViewById(R.id.tv_typeInput)
        var tv_numberInput: TextView = itemView.findViewById(R.id.tv_numberInput)

        fun bind(item: LotteryType){
            tv_typeInput.text = item.lotteryType
            tv_numberInput.text = item.lotteryTypeNumber.toString()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                //設定在父層級的充氣者
                val layoutInflater = LayoutInflater.from(parent.context)

                // 對新的 view 充氣
                //這邊的第一個參數是ViewHolder的外觀，需定義在layout檔中
                val view = layoutInflater
                    .inflate(R.layout.list_item_lottery, parent, false)

                //回傳ViewHolder
                return ViewHolder(view)
            }
        }
    }
}
