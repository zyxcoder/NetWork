package com.base.network

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private lateinit var btrequestNet: Button
    private lateinit var btSwitchNet: Button
    private lateinit var tvContent: TextView


    private lateinit var viewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java].apply {
            testData.observe(this@MainActivity, {
                tvContent.text = it.toString()
            })
        }
        btrequestNet = findViewById(R.id.btrequestNet)
        btSwitchNet = findViewById(R.id.btSwitchNet)
        tvContent = findViewById(R.id.tvContent)
        btrequestNet.setOnClickListener {
            viewModel.fetchTestDate()
        }
        btSwitchNet.setOnClickListener {
            //切换后请查看日志显示，此url为不可用状态
            RetrofitManager.INSTANCE.switchBaseUrl(ApiService.SERVER_URL2)
        }
    }
}