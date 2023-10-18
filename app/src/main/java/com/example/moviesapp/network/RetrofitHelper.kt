package com.example.moviesapp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
/**
 *  Retrofit instance for making network requests in the MoviesApp Android application.
 * It follows the Singleton pattern, ensuring that only one instance of Retrofit is created for the entire application's lifecycle.
 */
object RetrofitHelper {
    private const val BASE_URL="https://api.themoviedb.org/3/"
    val retrofitInstance: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}