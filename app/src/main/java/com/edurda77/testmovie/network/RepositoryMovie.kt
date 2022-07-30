package com.edurda77.testmovie.network

import com.edurda77.testmovie.model.API_KEY
import com.edurda77.testmovie.model.ModelMovie
import javax.inject.Inject

class RepositoryMovie @Inject constructor(private val apiService: ApiService) {
    suspend fun gatData(number: Int): List<ModelMovie> {
        val movieList = mutableListOf<ModelMovie>()
        val dataNetwork = apiService.getReviews(API_KEY, number)
        dataNetwork.results.forEach {
            movieList.add(
                ModelMovie(
                    titleMovie = it.title,
                    descriptionMovie = it.summary,
                    posterMovie =it.multimedia.posterPath,
                    hasMoreMovie = dataNetwork.hasMore,
                    maxResultsMovie = dataNetwork.maxResults
                )
            )
        }
        return movieList
    }
}