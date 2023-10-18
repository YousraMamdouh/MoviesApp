package com.example.moviesapp.network

import com.example.moviesapp.model.MovieResponse
/**
 * A network client for fetching movie data. It implements the `RemoteService` interface
 * to provide methods for retrieving movie information.
 */
class MoviesClient: RemoteService {
    /**
     * The API service used for making network requests to fetch movie data.
     */
    val apiService: ApiService by lazy {
        RetrofitHelper.retrofitInstance.create(ApiService::class.java)
    }

    companion object{
        private var instance: MoviesClient?=null
        /**
         * Get the singleton instance of the `MoviesClient`. If it doesn't exist, a new instance is created.
         */
        fun getInstance(): MoviesClient {
            return instance?: synchronized(this)
            {
                val temp= MoviesClient()
                instance=temp
                temp
            }
        }
    }
    /**
     * Fetch a list of popular movies from the API.
     *
     * @param page The page number for paginated results.
     * @return A `MovieResponse` object containing the list of movies.
     */
    override suspend fun getAllMovies(page:Int): MovieResponse {
        return apiService.getPopularMovies(page = page)
    }

}