package com.example.android.littlelottery


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.android.littlelottery.databinding.FragmentLotteryGoBinding

/**
 * A simple [Fragment] subclass.
 */
class LotteryGoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentLotteryGoBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_lottery_go, container, false)

        binding.buttonResult.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_lotteryGoFragment_to_lotteryResultFragment)
        )

        binding.buttonGo.setOnClickListener {
            binding.textViewPlayerId.text = "002"
            binding.imageViewPlayerImage.setImageResource(R.drawable.ic_launcher_foreground)
            binding.textViewAward.text = "大吉"
        }

//        binding.textViewPlayerId.text = "002"
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_lottery_go, container, false)
        return binding.root
    }


}
