package com.example.moviesapp.ui.seemore.view

import android.app.ProgressDialog.show
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.moviesapp.R
import com.example.moviesapp.data.models.Result
import com.example.moviesapp.databinding.ActivityMoreBinding
import com.example.moviesapp.databinding.FragmentMoviesBinding
import com.example.moviesapp.ui.details.view.DetailsActivity
import com.example.moviesapp.ui.favorite.viewmodel.MovieFavoriteViewModel
import com.example.moviesapp.ui.movies.adapter.NowPlayingMoviesAdapter
import com.example.moviesapp.ui.movies.adapter.NowPlayingMoviesAdapter.NowPlayingMovieClickListener
import com.example.moviesapp.ui.movies.adapter.PopularMoviesAdapter
import com.example.moviesapp.ui.movies.adapter.PopularMoviesAdapter.PopularMovieClickListener
import com.google.android.material.snackbar.Snackbar

class MoreActivity : AppCompatActivity(), PopularMovieClickListener {
    lateinit var binding: ActivityMoreBinding
    lateinit var moreAdapter: PopularMoviesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_more)
        val movie :  MutableList<Result> = intent.getSerializableExtra("NowShowing")as MutableList<Result>


        moreAdapter = PopularMoviesAdapter(movie,this)
        binding.rvMore.adapter = moreAdapter
    }
    override fun onPopularMovieClicked(movie: Result) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra("movie_model", movie)
        startActivity(intent)
    }

}