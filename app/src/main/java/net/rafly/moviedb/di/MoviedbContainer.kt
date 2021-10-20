package net.rafly.moviedb.di

import net.rafly.moviedb.data.repository.MoviedbRepositoryImpl
import net.rafly.moviedb.presentation.HomeViewModelFactory

class MoviedbContainer(
    moviedbRepositoryImpl: MoviedbRepositoryImpl
) {
    val homeViewModelFactory = HomeViewModelFactory(moviedbRepositoryImpl)
}