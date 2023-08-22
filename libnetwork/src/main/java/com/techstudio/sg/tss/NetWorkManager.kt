package com.techstudio.sg.tss

import me.jessyan.retrofiturlmanager.RetrofitUrlManager
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit

/**
 * Create by zyx_coder on 2023/7/6
 */
/**
 * 网络框架基类
 *
 * 具体实现请参考demo中RetrofitManager类
 */
abstract class NetWorkManager {

    fun <T> getServiceApi(serviceClass: Class<T>, baseUrl: String): T {
        val retrofitBuilder = Retrofit.Builder().baseUrl(baseUrl)
            .client(RetrofitUrlManager.getInstance().with(OkHttpClient.Builder()).apply {
                setHttpClientBuilder(this)
            }.build())
        return retrofitBuilder.addConverterFactory(setConverterFactory()).build()
            .create(serviceClass)
    }

    /**
     * 实现此方法添加拦截器
     *
     *
     * 1.由于服务器header缓存逻辑不知道，所以缓存策略只能自定义，这里提供一个缓存策略仅供参考
     * @see com.techstudio.sg.tss.CachingControlInterceptor
     *
     * 2.由于服务器token过期的状态未知，并且重新获取的方式也未知，所以不提供实现，若需要请自定义Interceptor
     *
     * 3.添加header的参数请自定义Interceptor
     *
     */
    abstract fun setHttpClientBuilder(builder: OkHttpClient.Builder): OkHttpClient.Builder


    /**
     * 切换baseUrl
     */
    fun switchBaseUrl(newBaseUrl: String) {
        RetrofitUrlManager.getInstance().setGlobalDomain(newBaseUrl)
    }

    abstract fun setConverterFactory(): Converter.Factory
}