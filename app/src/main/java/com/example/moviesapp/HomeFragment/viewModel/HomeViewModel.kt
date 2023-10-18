package com.example.moviesapp.HomeFragment.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.model.Movie
import com.example.moviesapp.model.RepoInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(private val _repo: RepoInterface): ViewModel() {
    private var currentPage = 1
    private var _movies: MutableLiveData<List<Movie>> = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>> = _movies



    init {
        getMoviesFromAPI()
    }

    fun loadMoreMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            val newMovies = _repo.getMoviesByPage(currentPage + 1).results
            currentPage++
            val currentList = _movies.value?.toMutableList() ?: mutableListOf()
            currentList.addAll(newMovies)
            _movies.postValue(currentList)
        }
    }
    private fun getMoviesFromAPI()
    {
        viewModelScope.launch(Dispatchers.IO) {
            val initialMovies = _repo.getMoviesByPage(currentPage).results
            _movies.postValue(initialMovies)
        }
    }
}