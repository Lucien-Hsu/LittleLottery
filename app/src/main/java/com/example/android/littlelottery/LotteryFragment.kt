package com.example.android.littlelottery


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.android.littlelottery.databinding.FragmentLotteryBinding

/**
 * A simple [Fragment] subclass.
 */
class LotteryFragment : Fragment() {
    private lateinit var viewModel: LotteryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //val binding = DataBindingUtil.inflate<FragmentTitleBinding>(inflater, R.layout.fragment_lottery, container, false)
        //return binding.root

        //取得 ViewModel
        viewModel = ViewModelProviders.of(this).get(LotteryViewModel::class.java)

        // Inflate the layout for this fragment
        val binding: FragmentLotteryBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_lottery,container, false)

        //創建recycle view 所需要的資料
        var data = mutableListOf<LotteryType>()
        //data.add(LotteryType(1,"111",1))

        //[recycle view] 創建適配器
        val adapter = LotteryAdapter(data)
        //綁定view
        binding.lotteryList.adapter = adapter

        //先載入目前內容
        data.addAll(viewModel.lottery.value!!)

        //籤種ID
        var lotteryId = 0

        //按下增加項目按鈕則呼叫viewModel.addItem()
        binding.buttonAddItem.setOnClickListener{
//            viewModel.addItem(2, binding.etType.getText().toString(), binding.etNumber.getText().toString().toInt())

            lotteryId += 1
            var lotteryTypeNumber = 1
            if(binding.etNumber.text.toString() != "") {
                lotteryTypeNumber = binding.etNumber.text.toString().toInt()
            }
            viewModel.addItem(lotteryId, binding.etType.text.toString(), lotteryTypeNumber)

            //因為目前不知道如何使用data biding 在資料更新時自動更新recycle view ，所以在這邊將viewModel的資料給data，
            //然後更新recycle view
            data.clear()
            data.addAll(viewModel.lottery.value!!)
            adapter.notifyDataSetChanged()
            Log.i("LotteryFragment", "片段更新資料")
            Log.i("LotteryFragment", "viewModel.lottery.value.toString()：${viewModel.lottery.value.toString()}")
        }

        var testA: Int = 5566
//        binding.buttonStartLottery.setOnClickListener { view: View ->
//            view.findNavController().navigate(LotteryFragmentDirections.actionLotteryFragmentToLotteryGoFragment())
//        }

//====================================================================================================================================
        //按下開始抽籤的按鈕則做
        binding.buttonStartLottery.setOnClickListener {

            //將 viewModel.lottery.value 轉為陣列
            var arraySize : Int = viewModel.lottery.value!!.size                    //取得陣列所需大小
            var lotteryArrayData = Array<LotteryType>(arraySize){                  //初始化要存資料的陣列
                LotteryType(1,"無",1)
            }

            var arrayIndex : Int = arraySize - 1                               //設定陣列所需的索引值
            for(i in 0..arrayIndex){                                     //以迴圈將List資料給陣列
                lotteryArrayData[i] = viewModel.lottery.value?.get(i)!!
            }

//            傳遞序列化後的抽籤資料
            val action = LotteryFragmentDirections.actionLotteryFragmentToLotteryGoFragment(lotteryArrayData)
            Navigation.findNavController(binding.root).navigate(action)
        }
//====================================================================================================================================

        //利用viewModel更新數據
//        viewModel.lottery.observe(this, Observer { newData ->
//            Log.i("LotteryFragment", "lottery 改變了")
//        })

        return binding.root
    }
}
