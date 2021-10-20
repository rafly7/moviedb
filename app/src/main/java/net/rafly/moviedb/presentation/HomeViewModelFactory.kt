package net.rafly.moviedb.presentation

import net.rafly.moviedb.data.repository.MoviedbRepositoryImpl

class HomeViewModelFactory(
    private val moviedbRepositoryImpl: MoviedbRepositoryImpl
) {
    fun create() : HomeViewModel = HomeViewModel(moviedbRepositoryImpl)
}