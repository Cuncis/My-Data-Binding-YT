package com.cuncisboss.mydatabindingyt.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.cuncisboss.mydatabindingyt.R
import com.cuncisboss.mydatabindingyt.databinding.ItemMovieBinding
import com.cuncisboss.mydatabindingyt.model.Movie

class MovieListAdapter(val itemClickListener: ItemClickListener): RecyclerView.Adapter<MovieListAdapter.ViewHolder>() {

    private var movies = arrayListOf<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = ViewHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_movie,
            parent,
            false
        )
    )

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.movie = movies[position]
        holder.binding.layoutLike.setOnClickListener {
            itemClickListener.onItemClick(holder.binding.layoutLike, movies[position])
        }
        holder.binding.buttonBook.setOnClickListener {
            itemClickListener.onItemClick(holder.binding.buttonBook, movies[position])
        }
    }

    fun setMovieList(newMovies: List<Movie>) {
        movies.clear()
        movies.addAll(newMovies)
        notifyDataSetChanged()
    }

    inner class ViewHolder(val binding: ItemMovieBinding)
        : RecyclerView.ViewHolder(binding.root)
}

interface ItemClickListener {
    fun onItemClick(view: View, movie: Movie)
}