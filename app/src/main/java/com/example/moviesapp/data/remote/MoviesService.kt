package com.example.storeapp.data.remote

import com.example.moviesapp.data.models.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesService {
    //
    @GET("movie/now_playing?language=en-US&api_key=0e011ef0bf44b4a30c1686fd9b03d8d7")
    suspend fun getNowPlayingMovies(

    ): MovieResponse

    @GET("movie/popular?language=en-US&api_key=0e011ef0bf44b4a30c1686fd9b03d8d7")
    suspend fun getPopularMovies(

    ): MovieResponse

}