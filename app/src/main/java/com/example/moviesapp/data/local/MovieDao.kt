package com.example.notesapp.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.moviesapp.data.models.Result

@Dao
interface MovieDao {

    @Query("SELECT * FROM movies")
    suspend fun getMovies(): List<Result>

    @Insert
    suspend fun addMovie(vararg note: Result)

    @Delete
    suspend fun deleteMovie(note: Result)
}