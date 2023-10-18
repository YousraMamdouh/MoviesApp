package com.example.moviesapp.network

import com.example.moviesapp.model.MovieResponse


interface RemoteService {
    suspend fun getAllMovies(page:Int): MovieResponse
}