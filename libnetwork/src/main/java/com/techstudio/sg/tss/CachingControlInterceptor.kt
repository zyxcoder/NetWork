package com.techstudio.sg.tss

import android.content.Context
import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Create by zyx_coder on 2023/7/7
 *
 * 缓存拦截器，如服务器缓存策略不同，请自定义Interceptor写出合适的拦截器
 *
 */
class CachingControlInterceptor(val mContext: Context, val cacheMaxTime: Long) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        if (!mContext.hasNetworkConnection()) {
            request = request.newBuilder().cacheControl(CacheControl.FORCE_CACHE).build()
        }
        val response = chain.proceed(request)
        if (mContext.hasNetworkConnection()) {
            val maxAge = 0
            // 有网络时 拉最新数据
            response.newBuilder().header("Cache-Control", "public, max-age=$maxAge").build()
        } else {
            // 无网络时，从缓存拿数据
            response.newBuilder()
                .header("Cache-Control", "public, only-if-cached, max-stale=$cacheMaxTime").build()
        }
        return response
    }
}