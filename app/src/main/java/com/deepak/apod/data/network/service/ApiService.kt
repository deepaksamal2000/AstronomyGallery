package com.deepak.apod.data.network.service

import com.deepak.apod.data.network.response.ApodResponse
import retrofit2.http.GET

interface ApiService {
    @GET("planetary/apod")
    suspend fun getPictureOfTheDay(): ApodResponse
}