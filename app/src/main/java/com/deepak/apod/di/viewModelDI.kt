package com.deepak.apod.di

import com.deepak.apod.module.astronomyHomePage.presentation.ApodViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { ApodViewModel(get()) }

}
