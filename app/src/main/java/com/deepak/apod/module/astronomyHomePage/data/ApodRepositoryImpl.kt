package com.deepak.apod.module.astronomyHomePage.data

import com.deepak.apod.data.local.db.dao.ApodDao
import com.deepak.apod.data.local.db.entity.ApodEntity
import com.deepak.apod.data.network.service.ApiService

class ApodRepositoryImpl
constructor(
    private val apiService: ApiService,
    private val apodDao: ApodDao
) : ApodRepository {

    override suspend fun fetchApodDetailFromNetwork() = apiService.getPictureOfTheDay()

    override suspend fun fetchApodDetailFromDB() = apodDao.getApodDetails()

    override suspend fun insertApodDetailToDB(apodEntity: ApodEntity) =
        apodDao.insertPicture(apodEntity)


}