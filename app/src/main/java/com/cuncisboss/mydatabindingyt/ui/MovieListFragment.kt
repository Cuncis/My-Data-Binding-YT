package com.cuncisboss.mydatabindingyt.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.cuncisboss.mydatabindingyt.R
import com.cuncisboss.mydatabindingyt.model.Movie
import com.cuncisboss.mydatabindingyt.repository.MovieListRepository
import kotlinx.android.synthetic.main.fragment_movie_list.*


class MovieListFragment : Fragment(R.layout.fragment_movie_list), ItemClickListener {
    private val TAG = "_MovieListFragment"

    private lateinit var movieListViewModel: MovieListViewModel
    private lateinit var movieListAdapter: MovieListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movieListAdapter = MovieListAdapter(this)
        rv_movies.adapter = movieListAdapter
        val repository = MovieListRepository()
        val factory = MoviesViewModelFactory(repository)
        movieListViewModel = ViewModelProvider(requireActivity(), factory).get(MovieListViewModel::class.java)
        movieListViewModel.getAllMovies().observe(viewLifecycleOwner, Observer { movies ->
            movieListAdapter.setMovieList(movies)
        })


    }

    override fun onItemClick(view: View, movie: Movie) {
        when (view.id) {
            R.id.layout_like -> {
                Toast.makeText(requireContext(), "Like button clicked", Toast.LENGTH_SHORT).show()
            }
            R.id.button_book -> {
                Toast.makeText(requireContext(), "button book clicked", Toast.LENGTH_SHORT).show()
            }
        }
    }
}