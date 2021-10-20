package net.rafly.moviedb.data.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build

class CheckInternet(
     context: Context
) {
        private val applicationContext = context.applicationContext
        fun isInternetAvailable(): Boolean {
            var result = false
            val connectivityManager = applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                connectivityManager?.let {
                     it.getNetworkCapabilities(connectivityManager.activeNetwork)?.apply {
                        result = when {
                            hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                            hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                            hasTransport(NetworkCapabilities.TRANSPORT_VPN) -> true
                            else -> false
                        }
                    }
                }
            } else {
                connectivityManager?.let {
                    it.activeNetworkInfo?.apply {
                        result = when (type){
                            ConnectivityManager.TYPE_WIFI -> true
                            ConnectivityManager.TYPE_MOBILE -> true
                            ConnectivityManager.TYPE_VPN -> true
                            else -> false
                        }
                    }
                }
            }
            return result
        }
}