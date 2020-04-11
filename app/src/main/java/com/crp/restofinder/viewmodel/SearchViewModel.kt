package com.crp.restofinder.viewmodel

import android.os.AsyncTask
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.crp.restofinder.network.SearchResponse
import com.crp.restofinder.network.ZomatoAPIInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.core.KoinComponent
import org.koin.core.inject

interface SearchView {
    fun setSearchData(searchResponse: SearchResponse)
}

class SearchViewModel : ViewModel(), KoinComponent {
    val zomatoAPIInterface: ZomatoAPIInterface by inject()
    var view: SearchView? = null

    fun getSearchData() {
        viewModelScope.launch(Dispatchers.IO) {
            val searchResponse = zomatoAPIInterface.getSearchRespone("city", "3")

            withContext(Main) {
                view?.setSearchData(searchResponse)
            }
        }
    }
}