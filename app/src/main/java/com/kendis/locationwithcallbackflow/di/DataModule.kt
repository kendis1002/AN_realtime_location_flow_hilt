package com.kendis.locationwithcallbackflow.di

import android.content.Context
import com.kendis.locationwithcallbackflow.data.AppRepository
import com.kendis.locationwithcallbackflow.data.DefaultAppRepository
import com.kendis.locationwithcallbackflow.data.SharedLocationManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideSharedLocationManager(
        @ApplicationContext context: Context,
        @ApplicationScope externalScope: CoroutineScope
    ): SharedLocationManager =
        SharedLocationManager(
            context = context,
            externalScope = externalScope
        )


    @Provides
    @Singleton
    fun provideRepository(sharedLocationManager: SharedLocationManager): AppRepository {
        return DefaultAppRepository(sharedLocationManager)
    }
}
