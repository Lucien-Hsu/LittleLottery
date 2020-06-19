package com.example.android.littlelottery

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LotteryViewModel: ViewModel(){

    //封裝所需資料
    private val _lottery: MutableLiveData<MutableList<LotteryType>> =
        MutableLiveData<MutableList<LotteryType>>().apply {
            value = mutableListOf()
        }
    val lottery: LiveData<MutableList<LotteryType>>
        get() = _lottery

    //封裝各籤種數量
//    private val _awardTypeNumber: MutableLiveData<MutableList<Int>> =
//        MutableLiveData<MutableList<Int>>().apply {
//        value = mutableListOf()
//    }
//    val awardTypeNumber: LiveData<MutableList<Int>>
//        get() = _awardTypeNumber

    //封裝籤種名稱
//    private val _awardType = MutableLiveData<String>()
//    val awardType: LiveData<String>
//        get() = _awardType

    //初始化
    init {
        //_lottery.value?.add(LotteryType(5,"",10))
        //_awardTypeNumber.value?.add(1)
        Log.i("LotteryViewModel", "初始化，籤種是：${_lottery.value}")
    }

    //增加籤種項目
    fun addItem(lotteryId: Int, lotteryType: String, lotteryTypeNumber: Int){
        _lottery.value?.add(LotteryType(lotteryId,lotteryType,lotteryTypeNumber))

        //_awardTypeNumber.value?.add(2)
        Log.i("LotteryViewModel", "增加籤種，總籤種數量是：${_lottery.value?.size}")
    }



    //覆寫onCleared()
    override fun onCleared() {
        super.onCleared()
    }
}