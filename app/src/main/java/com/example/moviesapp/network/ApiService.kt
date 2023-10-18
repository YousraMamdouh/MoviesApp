package com.example.moviesapp.network

import com.example.moviesapp.model.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Headers

import retrofit2.http.Query
/**
 * Retrofit API service interface for fetching popular movies from the remote server.
 */
interface ApiService{
    /**
     * Get a list of popular movies from the remote API.
     *
     * @param language The language for movie information (default is "en-US").
     * @param page The page number for paginated results.
     * @return A `MovieResponse` object containing the list of popular movies.
     */
    @Headers(NetworkConstants.authorization,NetworkConstants.accept)
    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("language") language: String = "en-US",
        @Query("page") page: Int
    ): MovieResponse

}