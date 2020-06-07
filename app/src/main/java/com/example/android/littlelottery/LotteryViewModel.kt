package com.example.android.littlelottery

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LotteryViewModel: ViewModel(){

    //封裝籤種數量
    private val _awardTypeNumber = MutableLiveData<MutableList<Int>>()
    val awardTypeNumber: LiveData<MutableList<Int>>
        get() = _awardTypeNumber

    //封裝籤種
    private val _awardType = MutableLiveData<Int>()
    val awardType: LiveData<Int>
        get() = _awardType

    //初始化
    init {
        _awardType.value = 5566
        _awardTypeNumber.value?.add(1)

    }

    //增加籤種項目
    fun addItem(){
        _awardTypeNumber.value?.add(2)
        Log.i("LotteryViewModel", "籤種數量是：${_awardTypeNumber.value?.size}")
    }



    //覆寫onCleared()
    override fun onCleared() {
        super.onCleared()
    }
}