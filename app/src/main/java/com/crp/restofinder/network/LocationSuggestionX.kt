package com.crp.restofinder.network

data class LocationSuggestionX(
    val city_id: Int,
    val city_name: String,
    val country_id: Int,
    val country_name: String,
    val entity_id: Int,
    val entity_type: String,
    val latitude: Double,
    val longitude: Double,
    val title: String
)