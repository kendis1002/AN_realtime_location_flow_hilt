package com.kendis.locationwithcallbackflow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.kendis.locationwithcallbackflow.ui.screens.main.GreetingScreen
import com.kendis.locationwithcallbackflow.ui.theme.LocationWithCallbackFlowTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LocationWithCallbackFlowTheme {
                // A surface container using the 'background' color from the theme
               GreetingScreen()
            }
        }
    }
}
