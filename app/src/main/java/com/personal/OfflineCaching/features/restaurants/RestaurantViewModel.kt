package com.personal.OfflineCaching.features.restaurants

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.personal.OfflineCaching.api.RestaurantApi
import com.personal.OfflineCaching.data.Restaurant
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RestaurantViewModel @Inject constructor(api: RestaurantApi) : ViewModel() {

    private val restaurantsLD = MutableLiveData<List<Restaurant>>()
    val restaurants: LiveData<List<Restaurant>> = restaurantsLD

    init {
        viewModelScope.launch {
            val restaurants = api.getRandomRestaurants()
            restaurantsLD.value = restaurants
        }
    }
}