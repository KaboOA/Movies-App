package com.example.moviesapp.ui.details.view

import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.example.moviesapp.R
import com.example.moviesapp.data.models.Result
import com.example.moviesapp.databinding.ActivityDetailsBinding
import com.example.moviesapp.ui.details.viewmodel.MovieDetailsViewModel
import com.google.android.material.snackbar.Snackbar

class DetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailsBinding
    val viewModel: MovieDetailsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_details)
        val movie: Result = intent.getSerializableExtra("movie_model") as Result
        viewModel.getAllMovies()
        viewModel.movies.observe(this) {
            if (it.contains(movie)) {
                binding.imageButton.setColorFilter(Color.YELLOW)

            }
        }
        val movieTitle = movie.title
        //intent.getStringExtra("title")
        val movieDes = movie.overview
        // intent.getStringExtra("Description")
        val imageUrl = movie.poster_path

        //intent.getStringExtra("Image")
        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w500$imageUrl")
            .into(binding.imageView)
        binding.title.text = movieTitle
        binding.Description.text = movieDes
            binding.imageButton.setOnClickListener {
                viewModel.movies.value?.let { movieList ->
                    if (movieList.contains(movie)) {
                        viewModel.deleteMovie(movie)
                        Snackbar.make(binding.main, "Movie Removed Successfully", Snackbar.LENGTH_LONG)
                            .show()
                        binding.imageButton.setColorFilter(Color.GRAY)


                    } else {
                        viewModel.addMovie(movie)
                        Snackbar.make(binding.main, "Movie Added Successfully", Snackbar.LENGTH_LONG)
                            .show()
                        binding.imageButton.setColorFilter(Color.YELLOW)
                    }
                }
            }
    }


}