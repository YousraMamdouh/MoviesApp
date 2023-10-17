package com.example.moviesapp.network

import com.example.moviesapp.model.MovieResponse
import retrofit2.Call
import retrofit2.Response

import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService{
    @Headers(NetworkConstants.authorization,NetworkConstants.accept)
    @GET("movie/popular")
    fun getPopularMovies(
        @Query("language") language: String,
        @Query("page") page: Int
    ): Call<MovieResponse>
}