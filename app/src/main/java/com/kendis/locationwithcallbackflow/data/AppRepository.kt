package com.kendis.locationwithcallbackflow.data

import android.location.Location
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

interface AppRepository {
    fun getLocationFlow(): Flow<Location>
}

@Singleton
class DefaultAppRepository @Inject constructor(private val sharedLocationManager: SharedLocationManager) :
    AppRepository {
    override fun getLocationFlow(): Flow<Location> = sharedLocationManager.locationFlow()
}
