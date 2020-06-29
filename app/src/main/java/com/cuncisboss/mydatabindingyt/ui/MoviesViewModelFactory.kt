package com.cuncisboss.mydatabindingyt.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cuncisboss.mydatabindingyt.repository.MovieListRepository

@Suppress("UNCHECKED_CAST")
class MoviesViewModelFactory(private val repository: MovieListRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MovieListViewModel(repository) as T
    }
}