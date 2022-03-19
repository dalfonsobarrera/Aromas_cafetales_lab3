package com.example.aromas_cafetales_lab3.ui.list

import android.graphics.Movie
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.aromas_cafetales_lab3.server.moviesrepository.MoviesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ListViewModel : ViewModel() {

    private val moviesRepository = MoviesRepository()

    private val loadMovies : MutableLiveData<ArrayList<Movie>> = MutableLiveData()
    val loadMoviesDone : LiveData<ArrayList<Movie>> = loadMovies

    fun getMovies() {
        GlobalScope.launch(Dispatchers.IO){
            loadMovies.postValue(moviesRepository.getMovies())
        }
    }

}