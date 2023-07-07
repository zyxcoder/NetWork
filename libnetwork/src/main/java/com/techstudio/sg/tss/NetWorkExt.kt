package com.techstudio.sg.tss

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities

/**
 * Create by zyx_coder on 2023/7/7
 * 用于判断有没有网络
 */
fun Context.hasNetworkConnection(): Boolean {
    val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val network = connectivityManager.activeNetwork
    val capabilities = connectivityManager.getNetworkCapabilities(network)
    if (capabilities != null) {
        return capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) || capabilities.hasTransport(
            NetworkCapabilities.TRANSPORT_WIFI
        ) || capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)
    }
    return false
}