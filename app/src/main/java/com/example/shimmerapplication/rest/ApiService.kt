package com.example.sampleapp.rest

import com.example.sampleapp.model.Data
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    fun getDetails(): Call<List<Data>>
}