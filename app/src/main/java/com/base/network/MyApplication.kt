package com.base.network

import android.app.Application

/**
 * Create by zyx_coder on 2023/7/7
 */
class MyApplication : Application() {

    companion object{
        lateinit var instance: MyApplication
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}