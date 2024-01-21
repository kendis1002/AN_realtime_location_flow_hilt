package com.kendis.locationwithcallbackflow

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope

@HiltAndroidApp
class LocationApplication : Application() {
    @OptIn(DelicateCoroutinesApi::class)
    val applicationScope = GlobalScope
}
