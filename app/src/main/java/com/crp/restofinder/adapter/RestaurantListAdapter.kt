package com.crp.restofinder.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.crp.restofinder.GlideApp
import com.crp.restofinder.R
import com.crp.restofinder.network.Restaurant
import com.crp.restofinder.network.RestaurantX
import kotlinx.android.synthetic.main.restaurant_item.view.*

class RestaurantListAdapter(
    val context: Context,
    private val list: List<Restaurant>,
    val adapterOnClick: (Any) -> Unit
) :
    RecyclerView.Adapter<RestaurantListAdapter.RestaurantListView>() {

    inner class RestaurantListView(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(restaurant: RestaurantX) {

            itemView.nameTv.text = restaurant.name
            itemView.ratingTv.text = restaurant.user_rating.aggregate_rating
            GlideApp.with(context)
                .load(restaurant.photos?.get(0)?.photo?.url)
                .into(itemView.photoIv)

            restaurant.name?.let { setItem(restaurant) }
        }

        private fun setItem(restaurantX: RestaurantX) {
            itemView.setOnClickListener { adapterOnClick(restaurantX) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantListView {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.restaurant_item, parent, false)
        return RestaurantListView(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RestaurantListView, position: Int) {
        holder.bind(list[position].restaurant)
    }
}