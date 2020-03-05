package com.crp.restofinder.network


import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

const val API_KEY = "4feaa2167c4dc6beadf629319423bd4b"

interface ZomatoAPIInterface {
    @Headers(
        "Accept: application/json",
        "user-key: $API_KEY"
    )
    @GET("locations?")
    suspend fun getLocationRespone(
        @Query("query") query: String,
        @Query("lat") latitude: String,
        @Query("lon") longitude: String
    ): LocationSuggestion

    @Headers(
        "Accept: application/json",
        "user-key: $API_KEY"
    )
    @GET("search?")
    suspend fun getSearchRespone(
        @Query("entity_type") entity_type: String,
        @Query("entity_id") city_id: String
    ): SearchResponse
}