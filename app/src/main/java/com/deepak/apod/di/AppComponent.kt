package com.deepak.apod.di

/**
 * Root DI component with list of multiple dependencies.
 */

val appComponent = listOf(
    NetworkDependency,
    viewModelModule,
    repositoryDependency,
    roomModule
)