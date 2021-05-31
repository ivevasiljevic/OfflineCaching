package com.personal.OfflineCaching.features.restaurants

import androidx.lifecycle.*
import com.personal.OfflineCaching.api.RestaurantApi
import com.personal.OfflineCaching.data.Restaurant
import com.personal.OfflineCaching.data.RestaurantRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RestaurantViewModel @Inject constructor(private val api: RestaurantApi, private val repo: RestaurantRepository) : ViewModel() {

    val restaurants = repo.getRestaurants().asLiveData()
}