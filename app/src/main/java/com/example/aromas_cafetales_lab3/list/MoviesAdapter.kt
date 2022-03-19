package com.example.aromas_cafetales_lab3.list

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MoviesAdapter(
    private val moviesList: List<Movie>,
    private val onItemClicked: (Movie) -> Unit
) : RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MoviesAdapter.MovieViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: MoviesAdapter.MovieViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

class MovieViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){

}