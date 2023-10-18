package com.example.moviesapp.model

interface RepoInterface {
    suspend fun getMoviesByPage(page: Int): MovieResponse

}