package com.example.moviesapp.network

import com.example.moviesapp.model.MovieResponse


interface RemoteService {
    /**
     * Retrieves a list of movies based on the specified page number.
     *
     * @param page The page number indicating which subset of movies to fetch.
     * @return A [MovieResponse] object containing information about the retrieved movies.
     */
    suspend fun getAllMovies(page:Int): MovieResponse
}