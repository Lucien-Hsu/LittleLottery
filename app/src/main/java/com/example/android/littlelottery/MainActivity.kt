package com.example.android.littlelottery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.widget.Button
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.android.littlelottery.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //延遲初始化，此修飾子可確保其值為非空
    lateinit var ButtonLottery: Button

    //建立綁定物件
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        //將綁定的XML充氣
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //[導航] 連接導航控制器
        val navController = this.findNavController(R.id.myNavHostFragment)
        //[導航] 將導航控制器連接至Action Bar
        NavigationUI.setupActionBarWithNavController(this, navController)

    }

    //[導航] 覆寫Up鍵功能
    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return navController.navigateUp()
    }
}
