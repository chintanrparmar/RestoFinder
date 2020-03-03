package com.crp.restofinder.view

import android.content.Intent
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityOptionsCompat
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders
import com.crp.restofinder.ActivityRetriever
import com.crp.restofinder.adapter.RestaurantListAdapter
import com.crp.restofinder.network.SearchResponse
import com.crp.restofinder.viewmodel.SearchView
import com.crp.restofinder.viewmodel.SearchViewModel
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.activity_restaurant_list.*
import kotlinx.android.synthetic.main.restaurant_item.*
import org.koin.core.KoinComponent
import org.koin.core.inject


class SearchResponseView(private val searchResponse: ViewGroup) : SearchView, KoinComponent,
    LayoutContainer {

    private val activityRetriever: ActivityRetriever by inject()
    override val containerView: View?
        get() = searchResponse

    init {
        val viewModel = ViewModelProviders.of(activityRetriever.getActivity() as FragmentActivity)
            .get(SearchViewModel::class.java)
        viewModel.view = this
        viewModel.getSearchData()

    }

    override fun setSearchData(searchResponse: SearchResponse) {

        restaurantRv.adapter =
            RestaurantListAdapter(activityRetriever.context, searchResponse.restaurants) {
                val intent = Intent(activityRetriever.context, RestaurantDetail::class.java)
                val abc: String = it as String
                intent.putExtra("url", abc)
                /*val options: ActivityOptionsCompat =
                    ActivityOptionsCompat.makeSceneTransitionAnimation(
                        activityRetriever.getActivity() as FragmentActivity,
                        (PhotoIv as View?)!!,
                        "coverPic"
                    )*/
                activityRetriever.context.startActivity(intent)
            }
    }
}