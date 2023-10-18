package com.example.moviesapp.HomeFragment.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.moviesapp.model.RepoInterface

/**
 * The `HomeViewModelFactory` is responsible for creating instances of the `HomeViewModel` class.
 * It implements the `ViewModelProvider.Factory` interface to provide the necessary dependencies
 * to the view model.
 *
 * @param _repo The repository interface used for data retrieval and management.
 */
class HomeViewModelFactory(private val _repo: RepoInterface) : ViewModelProvider.Factory {
    /**
     * Creates and returns an instance of the specified view model class.
     *
     * @param modelClass The class of the view model to create.
     * @return An instance of the `HomeViewModel` class with the required dependencies.
     * @throws IllegalArgumentException if the provided model class is not recognized.
     */
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            HomeViewModel(_repo) as T
        } else {
            throw IllegalArgumentException("View class not found")
        }

    }
}