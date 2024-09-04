package com.example.moviesapp.ui.movies.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.moviesapp.data.models.Result
import com.example.moviesapp.databinding.FragmentMoviesBinding
import com.example.moviesapp.ui.movies.adapter.NowPlayingMoviesAdapter
import com.example.moviesapp.ui.movies.adapter.NowPlayingMoviesAdapter.MovieClickListener
import com.example.moviesapp.ui.movies.adapter.PopularMoviesAdapter
import com.example.moviesapp.ui.movies.viewmodel.MoviesViewModel


class MoviesFragment : Fragment() , MovieClickListener
{
    val moviesViewModel : MoviesViewModel by viewModels()
    lateinit var nowShowingAdapter: NowPlayingMoviesAdapter

    lateinit var popularAdapter: PopularMoviesAdapter

    lateinit var binding: FragmentMoviesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentMoviesBinding.inflate(inflater,container,false)

        // Inflate the layout for this fragment


        moviesViewModel.getNowPlayingMovies()
        moviesViewModel.nowPlayingMovies.observe(viewLifecycleOwner, Observer {
            nowShowingAdapter= NowPlayingMoviesAdapter(it.results,this)
            binding.rvShowingrmovies.adapter=nowShowingAdapter
        })


        moviesViewModel.getPopularMovies()
        moviesViewModel.popularMovies.observe(viewLifecycleOwner, Observer {
            popularAdapter= PopularMoviesAdapter(it.results,this)
            binding.rvPopularmovies.adapter=popularAdapter
        })
        return binding.root

    }

    override fun onMovieClicked(movie: Result) {
    }

}