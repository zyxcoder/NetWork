package com.base.network

import com.techstudio.sg.tss.CachingControlInterceptor
import com.techstudio.sg.tss.NetWorkManager
import okhttp3.Cache
import okhttp3.OkHttpClient
import java.io.File
import java.util.concurrent.TimeUnit

/**
 * Create by zyx_coder on 2023/7/6
 * demo
 */
val apiService: ApiService by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
    RetrofitManager.INSTANCE.getServiceApi(ApiService::class.java, ApiService.SERVER_URL)
}

class RetrofitManager : NetWorkManager() {
    companion object {
        private const val CACHE_MAX_SIZE: Long = 1024 * 1024 * 50//50M
        private const val CACHE_MAX_TIME: Long = 60 * 60 * 24//最多缓存1天
        private const val DEFAULT_NET_TIME: Long = 10 //默认网络时间
        val INSTANCE: RetrofitManager by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            RetrofitManager()
        }
    }

    override fun setHttpClientBuilder(builder: OkHttpClient.Builder): OkHttpClient.Builder {
        return builder.apply {

            //设置 请求的缓存的大小跟位置
            val cacheFile = File(MyApplication.instance.cacheDir, "cache")
            val cache = Cache(cacheFile, CACHE_MAX_SIZE)
            addInterceptor(CachingControlInterceptor(MyApplication.instance, CACHE_MAX_TIME))
            cache(cache)



            connectTimeout(DEFAULT_NET_TIME, TimeUnit.SECONDS)
            readTimeout(DEFAULT_NET_TIME, TimeUnit.SECONDS)
            writeTimeout(DEFAULT_NET_TIME, TimeUnit.SECONDS)
        }
    }
}