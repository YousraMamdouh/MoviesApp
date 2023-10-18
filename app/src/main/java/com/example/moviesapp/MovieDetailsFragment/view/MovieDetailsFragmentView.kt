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


class MovieDetailsFragmentView : Fragment() {
    lateinit var imageView: ImageView
    lateinit var movieTitle: TextView
    lateinit var movieVote: TextView
    lateinit var movieOverview: TextView
    lateinit var movieLanguage: TextView


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
        movieLanguage = view.findViewById(R.id.originalLang)
        movieOverview = view.findViewById(R.id.movieOverview)
        movieTitle = view.findViewById(R.id.movieName)
        movieVote = view.findViewById(R.id.vote)
        imageView = view.findViewById(R.id.imageView)
        // Access Safe Args bundle
        val args = MovieDetailsFragmentViewArgs.fromBundle(requireArguments())
        val movie: Movie = args.movie

        // Populate views with movie data
        movieTitle.text = movie.title
        movieVote.text = "${movie.vote_average}"
        movieOverview.text = movie.overview
        movieLanguage.text = "${movie.original_language}"

        // Load the movie poster using Glide
        val posterUrl = "https://image.tmdb.org/t/p/w500${movie.poster_path}"
       Glide.with(this).load(posterUrl).into(imageView)
    }
}







