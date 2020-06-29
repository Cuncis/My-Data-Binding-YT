package com.cuncisboss.mydatabindingyt.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cuncisboss.mydatabindingyt.model.Movie
import com.cuncisboss.mydatabindingyt.repository.MovieListRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class MovieListViewModel(private val repository: MovieListRepository): ViewModel() {

    private val _movies = MutableLiveData<List<Movie>>()

    fun getAllMovies(): MutableLiveData<List<Movie>> {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getAllMovies()
            try {
                if (response.isSuccessful) {
                    val movies = repository.getAllMovies()
                    _movies.postValue(movies.body())
                } else {

                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        return _movies
    }

}