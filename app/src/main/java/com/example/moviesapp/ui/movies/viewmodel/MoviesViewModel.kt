package com.example.moviesapp.ui.movies.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.data.models.MovieResponse
import com.example.storeapp.data.remote.MoviesService
import com.example.storeapp.data.remote.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MoviesViewModel(val app: Application) : AndroidViewModel(app) {

    private var _nowPlayingMovies: MutableLiveData<MovieResponse> = MutableLiveData()
    val nowPlayingMovies: LiveData<MovieResponse> = _nowPlayingMovies
    private var _popularMovies: MutableLiveData<MovieResponse> = MutableLiveData()
    val popularMovies: LiveData<MovieResponse> = _popularMovies
    val apiKey = "0e011ef0bf44b4a30c1686fd9b03d8d7"
    val language = "en-US"

    fun getNowPlayingMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            val retrofit = RetrofitClient.getInstance(app.applicationContext)
            val moviesService = retrofit.create(MoviesService::class.java)
            val result = moviesService.getNowPlayingMovies()
            _nowPlayingMovies.postValue(result)
        }
    }

    fun getPopularMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            val retrofit = RetrofitClient.getInstance(app.applicationContext)
            val moviesService = retrofit.create(MoviesService::class.java)
            val result = moviesService.getPopularMovies()
            _popularMovies.postValue(result)
        }
    }

}