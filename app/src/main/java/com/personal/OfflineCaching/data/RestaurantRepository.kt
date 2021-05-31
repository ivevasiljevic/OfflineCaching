package com.personal.OfflineCaching.data

import androidx.room.RoomDatabase
import androidx.room.withTransaction
import com.personal.OfflineCaching.api.RestaurantApi
import com.personal.OfflineCaching.util.networkBoundResource
import javax.inject.Inject

class RestaurantRepository @Inject constructor(private val api: RestaurantApi, private val db: RestaurantDatabase) {

    private val restaurantDao = db.restaurantDao()

    fun getRestaurants() = networkBoundResource(
        query = {
            restaurantDao.getAllRestaurants()
        },
        fetch = {
            api.getRandomRestaurants()
        },
        saveFetchResult = {
            db.withTransaction {
                restaurantDao.deleteAllRestaurants()
                restaurantDao.insertRestaurants(it)
            }
        }
    )
}