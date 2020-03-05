package com.crp.restofinder.view

import android.content.Intent
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import com.crp.restofinder.utils.ActivityRetriever
import com.crp.restofinder.utils.Helper
import com.crp.restofinder.MainActivity
import com.crp.restofinder.RestaurantList
import com.crp.restofinder.network.LocationSuggestion
import com.crp.restofinder.viewmodel.LocationView
import com.crp.restofinder.viewmodel.LocationViewModel
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.core.KoinComponent
import org.koin.core.inject


class LocationResponseView(private val locationResponse: ViewGroup) :
    LocationView, KoinComponent,
    LayoutContainer {

    private val activityRetriever: ActivityRetriever by inject()
    override val containerView: View?
        get() = locationResponse

    init {
        goBtn.setOnClickListener {
            if (cityEt.text.toString().length >= 3) {
                Helper.hideKeyboard(activityRetriever.getActivity() as FragmentActivity)
                progressBar.visibility = VISIBLE
                val viewModel =
                    ViewModelProvider(activityRetriever.getActivity() as FragmentActivity)
                        .get(LocationViewModel::class.java)
                viewModel.view = this
                viewModel.getLocationData(
                    cityEt.text.toString(),
                    MainActivity.lat,
                    MainActivity.lon
                )
            } else {
                Toast.makeText(activityRetriever.context, "Enter valid name", Toast.LENGTH_SHORT)
                    .show()
            }
        }


    }

    override fun setLocationData(locationSuggestion: LocationSuggestion) {
        progressBar.visibility = GONE
        if (locationSuggestion.location_suggestions.isNotEmpty()) {
            val intent = Intent(activityRetriever.context, RestaurantList::class.java)
            intent.putExtra("city", locationSuggestion.location_suggestions[0].city_id.toString())
            intent.putExtra("location", locationSuggestion.location_suggestions[0].city_name)
            activityRetriever.context.startActivity(intent)
        } else {
            Toast.makeText(activityRetriever.context, "No Location Found", Toast.LENGTH_SHORT)
                .show()
        }
    }
}