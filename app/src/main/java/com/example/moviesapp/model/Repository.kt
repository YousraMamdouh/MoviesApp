package com.example.moviesapp.model

import com.example.moviesapp.network.RemoteService

/**
 * The `Repository` class serves as an intermediate layer that manages data retrieval from remote sources,
 * such as APIs or network services. It implements the `RepoInterface` and delegates data fetching operations
 * to the provided `RemoteService`.
 */
class Repository(var remoteSource: RemoteService) : RepoInterface {
    companion object {
        private var instance: Repository? = null

        /**
         * Provides a singleton instance of the `Repository`. If an instance already exists, it returns the existing one;
         * otherwise, it creates a new instance with the specified `RemoteService`.
         */
        fun getInstance(
            remoteSource: RemoteService,
        ): Repository {
            return instance ?: synchronized(this) {
                val temp = Repository(
                    remoteSource
                )
                instance = temp
                temp
            }
        }
    }

    /**
     * Retrieves a list of movies by page number from the remote source.
     *
     * @param page The page number to fetch.
     * @return A `MovieResponse` object containing a list of movies.
     */
    override suspend fun getMoviesByPage(page: Int): MovieResponse {
        return remoteSource.getAllMovies(page = page)
    }
}