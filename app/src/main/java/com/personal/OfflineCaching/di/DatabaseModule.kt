package com.personal.OfflineCaching.di

import android.app.Application
import androidx.room.Room
import com.personal.OfflineCaching.data.RestaurantDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(application: Application) : RestaurantDatabase =
        Room.databaseBuilder(application, RestaurantDatabase::class.java, "restaurant_database")
            .build()
}