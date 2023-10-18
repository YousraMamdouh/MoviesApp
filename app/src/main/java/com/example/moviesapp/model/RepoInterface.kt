package com.example.moviesapp.model

interface RepoInterface {
    suspend fun getAllMovies(): MovieResponse

}