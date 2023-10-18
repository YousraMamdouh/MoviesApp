package com.example.moviesapp.HomeFragment.view

import com.example.moviesapp.model.Movie

interface OnMovieClickListener {
    fun showMovieDetails(movie: Movie)
}