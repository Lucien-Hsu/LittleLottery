package com.example.android.littlelottery


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat.getSystemService
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.android.littlelottery.databinding.FragmentLotteryBinding

/**
 * A simple [Fragment] subclass.
 */
class LotteryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //val binding = DataBindingUtil.inflate<FragmentTitleBinding>(inflater, R.layout.fragment_lottery, container, false)
        //return binding.root

        // Inflate the layout for this fragment
        val binding: FragmentLotteryBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_lottery,container, false)

        binding.button.setOnClickListener(
            //取得導航
            Navigation.createNavigateOnClickListener(R.id.action_lotteryFragment_to_lotteryGoFragment)
        )

        return binding.root
    }
}
