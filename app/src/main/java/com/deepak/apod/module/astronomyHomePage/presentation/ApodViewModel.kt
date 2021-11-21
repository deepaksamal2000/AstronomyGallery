package com.deepak.apod.module.astronomyHomePage.presentation

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.deepak.apod.data.local.db.entity.toHomePageViewData
import com.deepak.apod.data.network.response.toApodEntity
import com.deepak.apod.data.network.response.toHomePageViewData
import com.deepak.apod.module.astronomyHomePage.data.ApodRepository
import com.deepak.apod.module.astronomyHomePage.doman.model.HomePageViewData
import com.deepak.apod.util.isOnline
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

class ApodViewModel(
    private val apodRepository: ApodRepository
) : ViewModel() {

    val apodDetail = MutableLiveData<HomePageViewData>()
    val errorMessage = MutableLiveData<String>()

    fun fetchData(context: Context?) {
        context?.apply {
            if (isOnline(context))
                fetchApodDetailFromNetwork()
            else fetchApodDetailFromDB()
        }
    }

    fun fetchApodDetailFromNetwork() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                try {
                    val result = apodRepository.fetchApodDetailFromNetwork()
                    apodDetail.postValue(result.toHomePageViewData())
                    apodRepository.insertApodDetailToDB(result.toApodEntity())
                } catch (throwable: Throwable) {
                    when (throwable) {
                        is IOException -> {
                            errorMessage.postValue("Network Error")
                        }
                        is HttpException -> {
                            val codeError = throwable.code()
                            val errorMessageResponse = throwable.message()
                            errorMessage.postValue("Error $errorMessageResponse : $codeError")
                        }
                        else -> {
                            errorMessage.postValue("Uknown error")
                        }
                    }
                }
            }
        }
    }

    fun fetchApodDetailFromDB() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                try {
                    val result = apodRepository.fetchApodDetailFromDB()
                    apodDetail.postValue(result.toHomePageViewData())
                } catch (e: Exception) {
                }
            }
        }


    }


}