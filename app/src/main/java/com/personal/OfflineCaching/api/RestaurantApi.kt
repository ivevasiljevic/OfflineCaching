package com.personal.OfflineCaching.api

import com.personal.OfflineCaching.data.Restaurant
import retrofit2.http.GET

interface RestaurantApi {

    companion object {
        const val BASE_URL = "https://random-data-api.com/api/"
    }

    @GET("restaurant/random_restaurant?size=30")
    suspend fun getRandomRestaurants() : List<Restaurant>
}