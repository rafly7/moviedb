package net.rafly.moviedb.data.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.HttpException
import java.io.IOException
import java.util.concurrent.TimeUnit

class NetworkConnectionInterceptor(
    private val checkInternet: CheckInternet
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        if (!checkInternet.isInternetAvailable())
            throw IOException("make sure you have an active data connection")
        return chain.proceed(chain.request())
    }
}