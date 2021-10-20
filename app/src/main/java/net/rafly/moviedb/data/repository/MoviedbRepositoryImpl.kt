package net.rafly.moviedb.data.repository

import net.rafly.moviedb.data.model.PopularResponse
import net.rafly.moviedb.data.network.Resource
import net.rafly.moviedb.data.network.SafeApiCall
import net.rafly.moviedb.data.remote.MoviedbApi
import net.rafly.moviedb.domain.MoviedbRepository

class MoviedbRepositoryImpl(private val api: MoviedbApi): SafeApiCall, MoviedbRepository {
    override suspend fun getPopular(
        includeAdult: Boolean,
        includeVideo: Boolean,
        page: Int
    ): Resource<PopularResponse> = safeApiCall {
         api.getPopular(includeAdult, includeVideo, page)
    }
}