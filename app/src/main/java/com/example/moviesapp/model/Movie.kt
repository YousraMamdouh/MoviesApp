package com.example.moviesapp.model

import java.io.Serializable

data class Movie(
    val id: Int,
    val title: String,
    val overview: String,
    val poster_path: String,
    val release_date: String,
    val vote_average: Double,
    val vote_count: Int,
    val original_language: String

):Serializable