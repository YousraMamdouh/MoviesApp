package com.example.moviesapp.MovieDetailsFragment.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.SearchView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviesapp.HomeFragment.view.MoviesAdapter
import com.example.moviesapp.HomeFragment.viewModel.HomeViewModel
import com.example.moviesapp.HomeFragment.viewModel.HomeViewModelFactory
import com.example.moviesapp.R
import com.example.moviesapp.model.Movie

/**
 * MovieDetailsFragmentView is a Fragment class that displays details about a specific movie.
 * It receives movie data via Safe Args and populates the layout with movie information, including title, vote average, overview, and more.
 */
class MovieDetailsFragmentView : Fragment() {
    // UI elements
    lateinit var imageView: ImageView
    lateinit var movieTitle: TextView
    lateinit var movieVote: TextView
    lateinit var movieOverview: TextView
    lateinit var movieLanguage: TextView

    // Safe Args to receive movie data
    lateinit var args: MovieDetailsFragmentViewArgs
    lateinit var movie: Movie

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_details_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Initialize and set up the UI elements
        setupView(view)
        // Retrieve movie data from Safe Args
        args = MovieDetailsFragmentViewArgs.fromBundle(requireArguments())
        movie = args.movie
        // Populate the layout with movie data
        setMovieDataOnLayout()
    }

    /**
     * Populates the layout with movie data, including title, vote average, overview, language, and an image poster.
     */
    private fun setMovieDataOnLayout() {
        movieTitle.text = movie.title
        movieVote.text = "${movie.voteAverage}"
        movieOverview.text = movie.overview
        movieLanguage.text = "${movie.originalLanguage}"

        val posterUrl = "https://image.tmdb.org/t/p/w500${movie.posterPath}"
        Glide.with(this).load(posterUrl).into(imageView)
    }

    /**
     * Initializes and sets up the UI elements.
     */
    private fun setupView(view: View) {
        movieLanguage = view.findViewById(R.id.originalLang)
        movieOverview = view.findViewById(R.id.movieOverview)
        movieTitle = view.findViewById(R.id.movieName)
        movieVote = view.findViewById(R.id.vote)
        imageView = view.findViewById(R.id.imageView)
    }
}







