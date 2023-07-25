package com.example.movie.data.service


import com.example.movie.core.util.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Services {
    val retrofitBuilder=Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
    val retrofit= retrofitBuilder.build()
    val service= retrofit.create(MovieAPI::class.java)
}