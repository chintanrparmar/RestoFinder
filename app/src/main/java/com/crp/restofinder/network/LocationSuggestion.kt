package com.crp.restofinder.network

data class LocationSuggestion(
    val has_more: Int,
    val has_total: Int,
    val location_suggestions: List<LocationSuggestionX>,
    val status: String,
    val user_has_addresses: Boolean
)