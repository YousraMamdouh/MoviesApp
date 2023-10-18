package com.example.moviesapp.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable
/**
 * The `Movie` data class represents information about a movie.
 *
 * @property id The unique identifier of the movie.
 * @property title The title of the movie.
 * @property overview A brief overview or summary of the movie.
 * @property posterPath The relative path to the movie's poster image.
 * @property releaseDate The release date of the movie.
 * @property voteAverage The average vote or rating given to the movie.
 * @property voteCount The number of votes or ratings for the movie.
 * @property originalLanguage The original language of the movie.
 */
data class Movie(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("overview") val overview: String,
    @SerializedName("poster_path") val posterPath: String,
    @SerializedName("release_date") val releaseDate: String,
    @SerializedName("vote_average") val voteAverage: Double,
    @SerializedName("vote_count") val voteCount: Int,
    @SerializedName("original_language") val originalLanguage: String
):Serializable