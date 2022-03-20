package com.example.aromas_cafetales_lab3.server.moviesrepository

import com.example.aromas_cafetales_lab3.server.MovieDB
import com.example.aromas_cafetales_lab3.server.model.Movie

class MoviesRepository {

    private val apiKey = "40f02bd18f55e7cbb0d8ed5dc8f6e4a6"

    suspend fun getMovies() = MovieDB.retrofit.getTopRated(apiKey)

}