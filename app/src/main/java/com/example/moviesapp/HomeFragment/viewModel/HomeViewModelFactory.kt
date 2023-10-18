package com.example.moviesapp.HomeFragment.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.moviesapp.model.RepoInterface

class HomeFragmentViewModelFactory(private val _repo: RepoInterface): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if(modelClass.isAssignableFrom(HomeViewModel::class.java)){
            HomeViewModel(_repo) as T
        }else{
            throw IllegalArgumentException("View class not found")
        }

    }
}