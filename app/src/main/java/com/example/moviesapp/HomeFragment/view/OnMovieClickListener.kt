package com.example.moviesapp.HomeFragment.view

import com.example.moviesapp.model.Movie
/**
 * The `OnMovieClickListener` interface defines a callback method for handling clicks on movie items.
 */
interface OnMovieClickListener {
    /**
     * Callback method invoked when a movie item is clicked to show its details.
     *
     * @param movie The movie object that was clicked and whose details need to be displayed.
     */
    fun showMovieDetails(movie: Movie)
}