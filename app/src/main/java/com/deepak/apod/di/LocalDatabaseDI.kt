package com.deepak.apod.di

import android.content.Context
import androidx.room.Room
import com.deepak.apod.data.constants.AppConstants
import com.deepak.apod.data.local.db.ApodDatabase
import com.deepak.apod.data.local.db.dao.ApodDao
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


val roomModule = module {
    single { provideApodDao(get()) }
    single { provideApodDb(context = androidContext()) }
}


fun provideApodDb( context: Context): ApodDatabase = Room
    .databaseBuilder(context, ApodDatabase::class.java, AppConstants.APP_DATABASE)
    .build()


fun provideApodDao(apodDb: ApodDatabase): ApodDao = apodDb.ApodDao()