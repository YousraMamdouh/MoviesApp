package com.example.moviesapp.model
/**
 * The `RepoInterface` is an interface that defines a contract for classes responsible for retrieving
 * a list of movies based on a specified page number.
 */
interface RepoInterface {
        /**
         * Retrieves a list of movies based on the given page number.
         *
         * @param page The page number for fetching movies.
         * @return A `MovieResponse` object containing a list of movies.
         */
    suspend fun getMoviesByPage(page: Int): MovieResponse

}