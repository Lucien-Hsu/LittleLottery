package com.example.android.littlelottery

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LotteryType(
    var lotteryId: Int,
    var lotteryType: String,
    var lotteryTypeNumber: Int
): Parcelable