package com.crp.restofinder.view

import android.content.Intent
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import com.crp.restofinder.ActivityRetriever
import com.crp.restofinder.R
import com.crp.restofinder.adapter.RestaurantListAdapter
import com.crp.restofinder.network.RestaurantX
import com.crp.restofinder.network.SearchResponse
import com.crp.restofinder.viewmodel.SearchView
import com.crp.restofinder.viewmodel.SearchViewModel
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.activity_restaurant_list.*
import org.koin.core.KoinComponent
import org.koin.core.inject


class SearchResponseView(private val searchResponse: ViewGroup, title: String) : SearchView,
    KoinComponent,
    LayoutContainer {

    private val activityRetriever: ActivityRetriever by inject()
    override val containerView: View?
        get() = searchResponse

    init {
        val viewModel = ViewModelProvider(activityRetriever.getActivity() as FragmentActivity)
            .get(SearchViewModel::class.java)
        viewModel.view = this
        viewModel.getSearchData()
        locationTv.text = title


    }

    override fun setSearchData(searchResponse: SearchResponse) {

        loadingTv.visibility = View.GONE
        progressBar.visibility = View.GONE
        countTv.text = activityRetriever.context.getString(
            R.string.restaurant_found,
            searchResponse.results_shown.toString()
        )
        restaurantRv.adapter =
            RestaurantListAdapter(
                activityRetriever.context,
                searchResponse.restaurants
            ) {
                val restaurantX = it as RestaurantX
                val intent = Intent(activityRetriever.context, RestaurantDetail::class.java)
                restaurantX.photos?.get(0)?.photo?.url.let { it1 ->
                    intent.putExtra("url", it1)
                }
                intent.putExtra("name", restaurantX.name)
                intent.putExtra("cuisine", restaurantX.cuisines)
                intent.putExtra("rating", restaurantX.user_rating.aggregate_rating)
                activityRetriever.context.startActivity(intent)
            }
    }
}