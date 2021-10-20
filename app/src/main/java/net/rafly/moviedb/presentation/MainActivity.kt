package net.rafly.moviedb.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import net.rafly.moviedb.MoviedbApplication
import net.rafly.moviedb.R
import net.rafly.moviedb.di.AppContainer
import net.rafly.moviedb.di.MoviedbContainer

class MainActivity : AppCompatActivity() {

    lateinit var appContainer: AppContainer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appContainer = (application as MoviedbApplication).appContainer
        appContainer.movieDbContainer = MoviedbContainer(appContainer.moviedbRepository)
        setContentView(R.layout.activity_main)
        val navHostFragment: NavHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        navHostFragment.navController
    }
}