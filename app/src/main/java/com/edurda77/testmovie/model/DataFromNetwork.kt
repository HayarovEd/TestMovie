package com.edurda77.testmovie.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class DataFromNetwork(
    @SerializedName("status")
    val title: String,
    @SerializedName("has_more")
    val hasMore: Boolean,
    @SerializedName("num_results")
    val maxResults: Int,
    @SerializedName("results")
    val results: List<Results>
) : Serializable


data class Results(
    @SerializedName("display_title")
    val title: String,
    @SerializedName("summary_short")
    val summary: String,
    @SerializedName("multimedia")
    val multimedia: Multimedia
    ) : Serializable

data class Multimedia(
    @SerializedName("type")
    val type: String,
    @SerializedName("src")
    val posterPath: String
) : Serializable
