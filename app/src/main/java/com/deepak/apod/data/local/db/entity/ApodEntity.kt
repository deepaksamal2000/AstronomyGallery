package com.deepak.apod.data.local.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.deepak.apod.module.astronomyHomePage.doman.model.HomePageViewData

@Entity(tableName = "apod")
data class ApodEntity(
    @PrimaryKey
    val id :Int = 1,
    val date: String? = null,
    val hdurl: String? = null,
    val explanation: String? = null,
    val title: String? = null,
    val url: String? = null
)
fun ApodEntity.toHomePageViewData() = HomePageViewData(
    date = date,
    hdurl = hdurl,
    explanation = explanation,
    title = title,
    url = url
)