package com.abdelrahman.myskeletonapp.data.remote.response

import com.abdelrahman.myskeletonapp.data.remote.model.UnsplashPhoto
import com.google.gson.annotations.SerializedName

data class UnsplashSearchResponse(
    @field:SerializedName("results") val results: List<UnsplashPhoto>,
    @field:SerializedName("total_pages") val totalPages: Int
)
