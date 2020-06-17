package com.example.android.littlelottery


import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat.getSystemService
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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
        data.add(LotteryType(1,"大吉",1))
        data.add(LotteryType(2,"中吉",2))
        data.add(LotteryType(3,"小吉",3))



        //[recycle view] 創建適配器
        val adapter = LotteryAdapter(data)
        //綁定view
        binding.lotteryList.adapter = adapter

        //按下增加項目按鈕則呼叫viewModel.addItem()
        binding.buttonAddItem.setOnClickListener{
            viewModel.addItem()
        }
        Log.i("LotteryFragment", "籤種數量是：${viewModel.lottery.value}")

        binding.buttonStartLottery.setOnClickListener(
            //取得導航
            Navigation.createNavigateOnClickListener(R.id.action_lotteryFragment_to_lotteryGoFragment)
        )

        //利用viewModel更新數據
        viewModel.lottery.observe(this, Observer { newData ->
            //binding.textView.text = newData.toString()
            //data.add(LotteryType(4,"小小吉",10))

            Log.i("LotteryViewModel", "lottery 改變了")
        })
        return binding.root
    }
}
