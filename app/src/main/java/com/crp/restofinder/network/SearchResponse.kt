package com.crp.restofinder.network

data class SearchResponse(
    val restaurants: List<Restaurant>,
    val results_found: Int,
    val results_shown: Int,
    val results_start: Int
)