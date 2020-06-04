package com.example.android.littlelottery


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.android.littlelottery.R.layout.fragment_title
import com.example.android.littlelottery.databinding.FragmentTitleBinding

/**
 * A simple [Fragment] subclass.
 */
class TitleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentTitleBinding = DataBindingUtil.inflate(inflater, fragment_title,container, false)


        binding.buttonLottery.setOnClickListener(
            //取得導航
            Navigation.createNavigateOnClickListener(R.id.action_titleFragment_to_lotteryFragment)
        )
        return binding.root
    }


}
