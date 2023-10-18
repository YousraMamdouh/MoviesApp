package com.example.moviesapp.network

import com.example.moviesapp.model.MovieResponse

class MoviesClient: RemoteService {

    val apiService: ApiService by lazy {
        RetrofitHelper.retrofitInstance.create(ApiService::class.java)
    }

    companion object{
        private var instance: MoviesClient?=null
        fun getInstance(): MoviesClient {
            return instance?: synchronized(this)
            {
                val temp= MoviesClient()
                instance=temp
                temp
            }
        }
    }

    override suspend fun getAllMovies(): MovieResponse {
        return apiService.getPopularMovies()
    }

}