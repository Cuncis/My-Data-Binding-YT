package com.cuncisboss.mydatabindingyt.api

import com.cuncisboss.mydatabindingyt.model.Movie
import retrofit2.Response
import retrofit2.http.GET

interface TheMovieApi {

    @GET("course-apis/recyclerview/movies")
    suspend fun getAllMovies(): Response<List<Movie>>

}