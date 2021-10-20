package net.rafly.moviedb

import android.app.Application
import net.rafly.moviedb.di.AppContainer

class MoviedbApplication: Application() {
    lateinit var appContainer: AppContainer

    override fun onCreate() {
        super.onCreate()
        appContainer = AppContainer(this)
    }
}