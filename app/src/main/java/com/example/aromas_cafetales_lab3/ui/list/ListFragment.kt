package com.example.aromas_cafetales_lab3.ui.list

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aromas_cafetales_lab3.databinding.FragmentListBinding
import com.example.aromas_cafetales_lab3.server.model.Movie

class ListFragment : Fragment() {

    companion object {
        fun newInstance() = ListFragment()
    }

    private lateinit var listViewModel: ListViewModel
    private lateinit var listBanding: FragmentListBinding
    private lateinit var moviesAdapter: MoviesAdapter
    private var moviesList: ArrayList<Movie> = ArrayList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        listBanding = FragmentListBinding.inflate(inflater, container, false)
        listViewModel = ViewModelProvider(this)[ListViewModel::class.java]
        return listBanding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        moviesAdapter = MoviesAdapter(moviesList, onItemClicked = {onMovieItemClicked(it)})

        listBanding.moviesRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@ListFragment.requireContext())
            adapter = moviesAdapter
            setHasFixedSize(false)
        }

        listViewModel.getMovies()

        listViewModel.loadMoviesDone.observe(viewLifecycleOwner) { result ->
            onLoadMoviesDoneSubscribe(result)
        }
    }

    private fun onLoadMoviesDoneSubscribe(moviesList: ArrayList<Movie>?) {
        moviesList?.let { movieList ->
            moviesAdapter.appendItems(movieList) }
    }

    private fun onMovieItemClicked(movie: Movie) {
        findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(movie))

    }
}