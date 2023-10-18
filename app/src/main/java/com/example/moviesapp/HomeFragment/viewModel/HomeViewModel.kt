package com.example.moviesapp.HomeFragment.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.model.Movie
import com.example.moviesapp.model.RepoInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * The `HomeViewModel` class is responsible for handling the business logic related to the main fragment
 * of the application, where a list of movies is displayed. It manages data retrieval and provides data to
 * the associated fragment. It also supports loading more movies and keeps track of the current page.
 */
class HomeViewModel(private val _repo: RepoInterface) : ViewModel() {
    // Current page of movie data
    private var currentPage = 1

    // MutableLiveData for storing a list of movies
    private var _movies: MutableLiveData<List<Movie>> = MutableLiveData<List<Movie>>()

    // LiveData for exposing the list of movies to the view
    val movies: LiveData<List<Movie>> = _movies

    /**
     * Initializes the ViewModel by fetching the initial set of movies from the repository.
     */
    init {
        getMoviesFromAPI()
    }

    /**
     * Loads more movies from the repository when the user is close to the end of the list.
     */
    fun loadMoreMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            // Fetch the next page of movies
            val newMovies = _repo.getMoviesByPage(currentPage + 1).results
            currentPage++
            // Append the new movies to the current list
            val currentList = _movies.value?.toMutableList() ?: mutableListOf()
            currentList.addAll(newMovies)
            _movies.postValue(currentList)
        }
    }

    /**
     * Retrieves the initial set of movies from the repository.
     */
    private fun getMoviesFromAPI() {
        viewModelScope.launch(Dispatchers.IO) {
            val initialMovies = _repo.getMoviesByPage(currentPage).results
            _movies.postValue(initialMovies)
        }
    }
}