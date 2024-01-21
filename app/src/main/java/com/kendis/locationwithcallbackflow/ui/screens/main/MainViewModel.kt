package com.kendis.locationwithcallbackflow.ui.screens.main

import android.location.Location
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kendis.locationwithcallbackflow.data.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val appRepository: AppRepository) : ViewModel() {
    private val _dataFlow = MutableStateFlow<Location?>(null)
    val dataFlow: StateFlow<Location?> get() = _dataFlow.asStateFlow()

    init {
        getLocationFlow()
    }

    private fun getLocationFlow() {
        viewModelScope.launch {
            appRepository.getLocationFlow().collectLatest { newLocation ->
                _dataFlow.update {
                    newLocation
                }
            }
        }
    }
}
