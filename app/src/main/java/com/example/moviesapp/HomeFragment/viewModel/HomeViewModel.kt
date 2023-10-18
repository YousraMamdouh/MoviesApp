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

    private var _stores: MutableLiveData<List<Movie>> = MutableLiveData<List<Movie>>()
    val products: LiveData<List<Movie>> = _stores



    init {
        getMoviesFromAPI()
    }


    private fun getMoviesFromAPI()
    {
        viewModelScope.launch(Dispatchers.IO) {
            _stores.postValue(_repo.getAllMovies().results)
        }
    }
}