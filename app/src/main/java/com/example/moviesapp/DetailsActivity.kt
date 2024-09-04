package com.example.moviesapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.adapters.TextViewBindingAdapter.setText
import com.bumptech.glide.Glide
import com.example.moviesapp.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_details)

        val movieTitle = intent.getStringExtra("title")
        val movieDes = intent.getStringExtra("Description")
        val imageUrl = intent.getStringExtra("Image")
        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w500" +imageUrl)
            .into(binding.imageView)
        binding.title.setText(movieTitle)
        binding.Description.setText(movieDes)

    }
}