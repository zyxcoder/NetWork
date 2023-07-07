package com.base.network

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

/**
 * Create by zyx_coder on 2023/7/6
 */
class MainViewModel : ViewModel() {


    val testData = MutableLiveData<DemoData>()


    fun fetchTestDate() {
        viewModelScope.launch {
            kotlin.runCatching {
                testData.value = apiService.getApiData()
            }.onFailure {
                Log.d("网络错误", it.message ?: "")
            }
        }
    }
}