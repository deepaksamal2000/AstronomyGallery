package com.deepak.apod.data.network.response

import com.deepak.apod.data.local.db.entity.ApodEntity
import com.deepak.apod.module.astronomyHomePage.doman.model.HomePageViewData
import com.google.gson.annotations.SerializedName

data class ApodResponse(

	@field:SerializedName("date")
	var date: String? = null,

	@field:SerializedName("copyright")
	val copyright: String? = null,

	@field:SerializedName("media_type")
	val mediaType: String? = null,

	@field:SerializedName("hdurl")
	val hdurl: String? = null,

	@field:SerializedName("service_version")
	val serviceVersion: String? = null,

	@field:SerializedName("explanation")
	val explanation: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)

fun ApodResponse.toHomePageViewData() = HomePageViewData(
	date = date,
	hdurl = hdurl,
	explanation = explanation,
	title = title,
	url = url
)

fun ApodResponse.toApodEntity() = ApodEntity(
	date = date,
	hdurl = hdurl,
	explanation = explanation,
	title = title,
	url = url
)