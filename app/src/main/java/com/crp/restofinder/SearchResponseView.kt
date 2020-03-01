package com.crp.restofinder

import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders
import com.crp.restofinder.network.SearchResponse
import kotlinx.android.extensions.LayoutContainer
import org.koin.core.KoinComponent
import org.koin.core.inject
import kotlinx.android.synthetic.main.activity_main.*


class SearchResponseView(val searchView: ViewGroup) : SearchView, KoinComponent, LayoutContainer {

    val activityRetriever: ActivityRetriever by inject()
    override val containerView: View?
        get() = searchView

    init {
        val viewModel = ViewModelProviders.of(activityRetriever.getActivity() as FragmentActivity)
            .get(SearchViewModel::class.java)
        viewModel.view = this
        viewModel.getSearchData()

    }

    override fun setSearchData(searchResponse: SearchResponse) {
        textView.text = searchResponse.results_found.toString()
    }
}