package com.example.aromas_cafetales_lab3.server.moviesrepository

import com.example.aromas_cafetales_lab3.server.MovieDB
import com.example.aromas_cafetales_lab3.server.model.Movie

class MoviesRepository {

    private val apiKey = "7f6138ac3abe53d63ccc58430b650214"

    suspend fun getMovies() = MovieDB.retrofit.getTopRated(apiKey)

}