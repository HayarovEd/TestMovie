package com.edurda77.testmovie.network

import com.edurda77.testmovie.model.DataFromNetwork
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("svc/movies/v2/reviews/all.json")
    suspend fun getReviews(
        @Query("api-key") apiKey: String,
        @Query("offset") number: Int
    ): DataFromNetwork
}