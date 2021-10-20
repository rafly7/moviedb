package net.rafly.moviedb.di

import android.content.Context
import net.rafly.moviedb.data.network.CheckInternet
import net.rafly.moviedb.data.network.NetworkConnectionInterceptor
import net.rafly.moviedb.data.network.RemoteDataSource
import net.rafly.moviedb.data.remote.MoviedbApi
import net.rafly.moviedb.data.repository.MoviedbRepositoryImpl

class AppContainer(context: Context) {
    private val remoteDataSource = RemoteDataSource()
    private val checkInternet = CheckInternet(context)
    private val networkConnectionInterceptor = NetworkConnectionInterceptor(checkInternet)
    private val api = remoteDataSource.buildApi(MoviedbApi::class.java, networkConnectionInterceptor)

    val moviedbRepository = MoviedbRepositoryImpl(api)

    var movieDbContainer: MoviedbContainer? = null
}