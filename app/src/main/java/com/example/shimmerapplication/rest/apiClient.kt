package com.example.shimmerapplication.rest

import com.example.sampleapp.rest.apiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object apiClient {
        private val url: String = "http://5e510330f2c0d300147c034c.mockapi.io/"
        fun getClient() =
            Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build()
                .create(apiService :: class.java)
}