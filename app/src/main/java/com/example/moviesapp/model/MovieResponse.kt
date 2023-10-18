package com.example.moviesapp.model

import java.io.Serializable
/**
 * The `MovieResponse` data class represents the response structure for a list of movies retrieved from a data source.
 *
 * @param page The page number of the movie list.
 * @param results A list of [Movie] objects representing the movies.
 */
data class MovieResponse(
    val page: Int,
    val results: List<Movie>

):Serializable