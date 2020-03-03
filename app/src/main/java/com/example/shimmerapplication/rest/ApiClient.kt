package com.example.shimmerapplication.rest

import com.example.sampleapp.rest.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

        val apiService: ApiService by lazy {
            val retrofit = Retrofit.Builder()
                .baseUrl("http://5e510330f2c0d300147c034c.mockapi.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return@lazy retrofit.create(ApiService::class.java)
        }

}

