package com.example.moviesapp.ui.movies.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.snapshots.Snapshot.Companion.observe
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.moviesapp.ui.details.view.DetailsActivity
import com.example.moviesapp.data.models.Result
import com.example.moviesapp.databinding.FragmentMoviesBinding
import com.example.moviesapp.ui.movies.adapter.NowPlayingMoviesAdapter
import com.example.moviesapp.ui.movies.adapter.NowPlayingMoviesAdapter.NowPlayingMovieClickListener
import com.example.moviesapp.ui.movies.adapter.PopularMoviesAdapter

import com.example.moviesapp.ui.movies.adapter.PopularMoviesAdapter.PopularMovieClickListener
import com.example.moviesapp.ui.movies.viewmodel.MoviesViewModel
import com.example.moviesapp.ui.seemore.view.MoreActivity
import java.io.Serializable


class MoviesFragment : Fragment(), NowPlayingMovieClickListener,PopularMovieClickListener {
    val moviesViewModel: MoviesViewModel by viewModels()
    lateinit var nowShowingAdapter: NowPlayingMoviesAdapter

    lateinit var popularAdapter: PopularMoviesAdapter

    lateinit var binding: FragmentMoviesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMoviesBinding.inflate(inflater, container, false)

        binding.seemore1.setOnClickListener {
            moviesViewModel.nowPlayingMovies.observe(viewLifecycleOwner, Observer {
                val intent = Intent(context, MoreActivity::class.java)
            intent.putExtra("NowShowing",it.results as Serializable)
            startActivity(intent)
        })
        }

        binding.seemore2.setOnClickListener {
            moviesViewModel.popularMovies.observe(viewLifecycleOwner, Observer {
                val intent = Intent(context, MoreActivity::class.java)
                intent.putExtra("NowShowing",it.results as Serializable)
                startActivity(intent)
            })
        }


        moviesViewModel.getNowPlayingMovies()
        moviesViewModel.nowPlayingMovies.observe(viewLifecycleOwner, Observer {
            nowShowingAdapter = NowPlayingMoviesAdapter(it.results.subList(0,5), this)
            binding.rvShowingrmovies.adapter = nowShowingAdapter
        })


        moviesViewModel.getPopularMovies()
        moviesViewModel.popularMovies.observe(viewLifecycleOwner, Observer {
            popularAdapter = PopularMoviesAdapter(it.results.subList(0,5), this)
            binding.rvPopularmovies.adapter = popularAdapter
        })

        return binding.root

    }

    override fun onNowPlayingMovieClicked(movie: Result) {
        val intent = Intent(context, DetailsActivity::class.java)
        intent.putExtra("movie_model", movie)
        startActivity(intent)
    }

    override fun onPopularMovieClicked(movie: Result) {
        val intent = Intent(context, DetailsActivity::class.java)
        intent.putExtra("movie_model", movie)
        startActivity(intent)
    }

}