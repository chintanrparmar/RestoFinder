package com.crp.restofinder.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.crp.restofinder.network.LocationSuggestion
import com.crp.restofinder.network.ZomatoAPIInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.core.KoinComponent
import org.koin.core.inject

interface LocationView {
    fun setSearchData(searchResponse: LocationSuggestion)
}

class LocationViewModel : ViewModel(), KoinComponent {
    private val zomatoAPIInterface: ZomatoAPIInterface by inject()
    var view: LocationView? = null

    fun getLocationData(cityName: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val locationResponse = zomatoAPIInterface.getLocationRespone(cityName)
            withContext(Main) {
                view?.setSearchData(locationResponse)
            }
        }
    }
}