package net.rafly.moviedb.data.remote

import net.rafly.moviedb.common.Constants
import net.rafly.moviedb.data.model.PopularModel
import net.rafly.moviedb.data.model.PopularResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviedbApi {
    @GET("3/discover/movie?api_key=${Constants.API_KEY}&language=en-US&sort_by=popularity.desc")
    suspend fun getPopular(
        @Query("include_adult") includeAdult: Boolean,
        @Query("include_video") includeVideo: Boolean,
        @Query("page") page: Int,
    ) : PopularResponse
}