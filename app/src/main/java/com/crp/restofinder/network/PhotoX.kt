package com.crp.restofinder.network

data class PhotoX(
    val caption: String,
    val friendly_time: String,
    val height: Int,
    val id: String,
    val res_id: Int,
    val thumb_url: String,
    val timestamp: Int,
    val url: String,
    val user: User,
    val width: Int
)