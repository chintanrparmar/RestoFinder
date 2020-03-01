package com.crp.restofinder.view

import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders
import com.crp.restofinder.ActivityRetriever
import com.crp.restofinder.network.LocationSuggestion
import com.crp.restofinder.viewmodel.LocationView
import com.crp.restofinder.viewmodel.LocationViewModel
import kotlinx.android.extensions.LayoutContainer
import org.koin.core.KoinComponent
import org.koin.core.inject
import kotlinx.android.synthetic.main.activity_main.*


class LocationResponseView(val locationResponse: ViewGroup) : LocationView, KoinComponent, LayoutContainer {

    val activityRetriever: ActivityRetriever by inject()
    override val containerView: View?
        get() = locationResponse

    init {
        val viewModel = ViewModelProviders.of(activityRetriever.getActivity() as FragmentActivity)
            .get(LocationViewModel::class.java)
        viewModel.view = this
        viewModel.getSearchData()

    }

    override fun setSearchData(searchResponse: LocationSuggestion) {
        textView.text = searchResponse.status.toString()
    }
}