package com.deepak.apod.di

import com.deepak.apod.module.astronomyHomePage.data.ApodRepository
import com.deepak.apod.module.astronomyHomePage.data.ApodRepositoryImpl
import org.koin.dsl.module

val repositoryDependency = module{
    single <ApodRepository>{ ApodRepositoryImpl(get(),get()) }
}