package com.crp.restofinder.view

import android.content.Intent
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import com.crp.restofinder.ActivityRetriever
import com.crp.restofinder.network.LocationSuggestion
import com.crp.restofinder.viewmodel.LocationView
import com.crp.restofinder.viewmodel.LocationViewModel
import kotlinx.android.extensions.LayoutContainer
import org.koin.core.KoinComponent
import org.koin.core.inject


class LocationResponseView(private val locationResponse: ViewGroup, cityName: String) :
    LocationView, KoinComponent,
    LayoutContainer {

    private val activityRetriever: ActivityRetriever by inject()
    override val containerView: View?
        get() = locationResponse

    init {
        val viewModel = ViewModelProvider(activityRetriever.getActivity() as FragmentActivity)
            .get(LocationViewModel::class.java)
        viewModel.view = this
        viewModel.getLocationData(cityName)

    }

    override fun setSearchData(locationResponse: LocationSuggestion) {
        val intent = Intent(activityRetriever.context, RestaurantList::class.java)
        intent.putExtra("city", locationResponse.location_suggestions[0].city_id.toString())
        intent.putExtra("location", locationResponse.location_suggestions[0].city_name)
        activityRetriever.context.startActivity(intent)
    }
}