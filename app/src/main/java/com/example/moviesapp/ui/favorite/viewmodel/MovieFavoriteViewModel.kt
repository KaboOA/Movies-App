package com.example.moviesapp.ui.favorite.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.data.models.Result
import com.example.notesapp.data.local.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieFavoriteViewModel(val app: Application) : AndroidViewModel(app) {

    val _movies: MutableLiveData<List<Result>> = MutableLiveData()
    val movies: LiveData<List<Result>> = _movies

    fun getAllMovies(){
        viewModelScope.launch(Dispatchers.IO) {
            val movieDao = AppDatabase.DatabaseBuilder.getInstance(app.applicationContext).movieDao()

            val result = movieDao.getMovies()
            withContext(Dispatchers.Main){
                _movies.postValue(result)
            }
        }
    }
}