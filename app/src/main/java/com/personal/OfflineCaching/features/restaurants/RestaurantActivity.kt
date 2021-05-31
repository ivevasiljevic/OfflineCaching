package com.personal.OfflineCaching.features.restaurants

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.personal.OfflineCaching.databinding.ActivityRestaurantBinding
import com.personal.OfflineCaching.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RestaurantActivity : AppCompatActivity() {

    private val viewModel: RestaurantViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityRestaurantBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val restaurantAdapter = RestaurantAdapter()

        binding.apply {
            recView.apply {
                adapter = restaurantAdapter
                layoutManager = LinearLayoutManager(this@RestaurantActivity)
            }
        }

        viewModel.restaurants.observe(this, { result ->
            restaurantAdapter.submitList(result.data)

            binding.apply {
                swipeRefresh.isRefreshing = result is Resource.Loading && result.data.isNullOrEmpty()
                textViewDataError.isVisible = result is Resource.Error && result.data.isNullOrEmpty()

                textViewDataError.text = result?.message
            }
        })
    }
}