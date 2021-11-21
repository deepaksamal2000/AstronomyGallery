package com.deepak.apod.module.astronomyHomePage.data

import com.deepak.apod.data.local.db.entity.ApodEntity
import com.deepak.apod.data.network.response.ApodResponse

interface ApodRepository {
    suspend fun fetchApodDetailFromNetwork():ApodResponse
    suspend fun fetchApodDetailFromDB():ApodEntity
    suspend fun insertApodDetailToDB(apodEntity: ApodEntity)
}