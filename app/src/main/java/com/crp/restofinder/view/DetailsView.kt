package com.crp.restofinder.view

import android.view.View
import android.view.ViewGroup
import com.crp.restofinder.R
import com.crp.restofinder.utils.ActivityRetriever
import com.crp.restofinder.utils.GlideApp
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.activity_restaurant_detail.*
import org.koin.core.KoinComponent
import org.koin.core.inject

class DetailsView(private val detailsView: ViewGroup) : KoinComponent, LayoutContainer {

    private val activityRetriever: ActivityRetriever by inject()

    override val containerView: View?
        get() = detailsView

    init {
        restNameTv.text = activityRetriever.getActivity()?.intent?.getStringExtra("name")
        cuisineTv.text = activityRetriever.getActivity()?.intent?.getStringExtra("cuisine")
        ratingTv.text =
            activityRetriever.context.getString(
                R.string.rating,
                activityRetriever.getActivity()?.intent?.getStringExtra("rating")
            )

        activityRetriever.getActivity()?.let {
            GlideApp.with(it)
                .load(activityRetriever.getActivity()?.intent?.getStringExtra("url"))
                .into(coverIv)
        }

        backIv.setOnClickListener { activityRetriever.getActivity()?.finish() }
    }

}