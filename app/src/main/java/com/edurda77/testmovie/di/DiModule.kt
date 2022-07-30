package com.edurda77.testmovie.di

import com.edurda77.testmovie.network.ApiService
import com.edurda77.testmovie.network.RepositoryMovie
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DiModule {
    @Provides
    fun providesUrl() = "https://api.nytimes.com/"

    @Provides
    @Singleton
    fun providesApiService(url: String): ApiService =
        Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    @Provides
    @Singleton
    fun provideMainRemoteData(apiService: ApiService) : RepositoryMovie = RepositoryMovie(apiService)
}