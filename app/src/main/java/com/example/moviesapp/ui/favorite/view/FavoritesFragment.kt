package com.example.moviesapp.ui.favorite.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.moviesapp.data.models.Result
import com.example.moviesapp.databinding.FragmentFavoritesBinding
import com.example.moviesapp.ui.details.view.DetailsActivity
import com.example.moviesapp.ui.favorite.viewmodel.MovieFavoriteViewModel
import com.example.moviesapp.ui.movies.adapter.PopularMoviesAdapter

class FavoritesFragment : Fragment(), PopularMoviesAdapter.PopularMovieClickListener {
    val movieFavoriteViewModel: MovieFavoriteViewModel by viewModels()

    lateinit var favoriteAdapter: PopularMoviesAdapter

    lateinit var binding: FragmentFavoritesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoritesBinding.inflate(inflater, container, false)

        movieFavoriteViewModel.getAllMovies()
        movieFavoriteViewModel.movies.observe(viewLifecycleOwner) {
            favoriteAdapter = PopularMoviesAdapter(it, this)
            binding.rvFav.adapter = favoriteAdapter

        }

        return  binding.root
    }

    override fun onPopularMovieClicked(movie: Result) {
        val intent = Intent(context, DetailsActivity::class.java)

        intent.putExtra("movie_model", movie)
        startActivity(intent)
    }
}
