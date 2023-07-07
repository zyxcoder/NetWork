package com.base.network

import retrofit2.http.GET

/**
 * Create by zyx_coder on 2023/7/6
 */
interface ApiService {

    companion object {
        const val SERVER_URL = "http://data.live.126.net/"
        const val SERVER_URL2 = "http://xxxx.net/"
        const val SERVER_URL3 = "http://yyy.126.net/"
    }


    @GET("livechannel/previewlist.json")
    suspend fun getApiData(): DemoData
}