package net.rafly.moviedb.domain

import net.rafly.moviedb.data.model.PopularModel
import net.rafly.moviedb.data.model.PopularResponse
import net.rafly.moviedb.data.network.Resource

interface MoviedbRepository {
    suspend fun getPopular(includeAdult: Boolean, includeVideo: Boolean, page: Int): Resource<PopularResponse>
}