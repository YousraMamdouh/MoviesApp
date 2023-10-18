package com.example.moviesapp.model

import java.io.Serializable

data class MovieResponse(
    val page: Int,
    val results: List<Movie>

):Serializable