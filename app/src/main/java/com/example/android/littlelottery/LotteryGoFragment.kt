package com.example.android.littlelottery


import android.icu.lang.UCharacter.GraphemeClusterBreak.L
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.android.littlelottery.databinding.FragmentLotteryGoBinding

/**
 * A simple [Fragment] subclass.
 */
class LotteryGoFragment : Fragment() {
    private lateinit var viewModel: LotteryViewModel

    //接收safe-args
    val args: LotteryGoFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //取得 ViewModel
        viewModel = ViewModelProviders.of(this).get(LotteryViewModel::class.java)

        //資料綁定
        val binding: FragmentLotteryGoBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_lottery_go, container, false)

        //創建抽籤用List
        var lotteryGoMuList = mutableListOf<String>()
        //計算總籤數
        var lotteryNumber = 0
        for(i in 1..args.LotteryList.size){
            lotteryNumber += args.LotteryList[i-1].lotteryTypeNumber

            //創建籤
            for(j in 1..args.LotteryList[i-1].lotteryTypeNumber){
                lotteryGoMuList.add(args.LotteryList[i-1].lotteryType)
            }
        }

        //打亂抽籤用List
        var lotteryGoList = lotteryGoMuList.shuffled()
        //初始化抽獎者ID
        var playerId = 0

        //按下抽籤按鈕則做
        binding.buttonGo.setOnClickListener {
            playerId += 1
            if(playerId <= lotteryNumber) {
                binding.textViewPlayerId.text = "抽獎者編號：" + playerId                         //顯示抽獎者編號
                binding.imageViewPlayerImage.setImageResource(R.drawable.ic_launcher_foreground)    //改變圖片
                binding.textViewAward.text = lotteryGoList[playerId - 1]        //顯示抽中獎項
//            Log.i("LotteryGoFragment", "viewModel.lottery.value.toString()：${viewModel.lottery.value.toString()}")
            }else{
                binding.textViewPlayerId.text = ""
                binding.textViewAward.text = "籤筒已抽完!"
            }
        }

        //按下看結果按鈕則做
        binding.buttonResult.setOnClickListener {
            //將 lotteryGoList 轉為陣列
            var arraySize: Int = lotteryGoList.size                    //取得陣列所需大小
            var resultData = Array<String>(arraySize) { "" }//初始化要存資料的陣列

            var arrayIndex: Int = arraySize - 1                               //設定陣列所需的索引值
            for (i in 0..arrayIndex) {                                     //以迴圈將List資料給陣列
                resultData[i] = lotteryGoList.get(i)
            }

            //導航並傳遞結果陣列
            val action = LotteryGoFragmentDirections.actionLotteryGoFragmentToLotteryResultFragment(resultData)
            Navigation.findNavController(binding.root).navigate(action)
        }

        return binding.root
    }


}
