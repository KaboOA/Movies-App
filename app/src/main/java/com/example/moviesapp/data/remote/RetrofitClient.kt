package com.example.storeapp.data.remote


import android.content.Context
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


class RetrofitClient {

    companion object {

        private var retrofit: Retrofit? = null

        fun getInstance(context: Context): Retrofit {
            if (retrofit == null) {

                val moshi = Moshi.Builder()
                    .add(KotlinJsonAdapterFactory())
                    .build()

                retrofit = Retrofit.Builder()
                    .baseUrl("https://api.themoviedb.org/3/")
                    .addConverterFactory(MoshiConverterFactory.create())
                    .build()
            }
            return retrofit!!
        }

    }

}