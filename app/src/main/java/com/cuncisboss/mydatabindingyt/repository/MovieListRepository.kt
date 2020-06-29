package com.cuncisboss.mydatabindingyt.repository

import com.cuncisboss.mydatabindingyt.api.ApiClient
import com.cuncisboss.mydatabindingyt.api.TheMovieApi

class MovieListRepository {

    suspend fun getAllMovies() = ApiClient.theMovieApi.getAllMovies()

}