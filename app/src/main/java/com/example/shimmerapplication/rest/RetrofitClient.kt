package com.example.shimmerapplication.rest

import com.example.sampleapp.rest.apiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
        private const val url: String = "http://5e510330f2c0d300147c034c.mockapi.io/"
        fun getClientInstance(): Retrofit = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
}