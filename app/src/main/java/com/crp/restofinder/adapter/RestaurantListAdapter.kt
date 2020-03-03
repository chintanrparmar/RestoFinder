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

class RestaurantListAdapter(
    val context: Context,
    private val list: List<Restaurant>,
    val adapterOnClick: (Any) -> Unit
) :
    RecyclerView.Adapter<RestaurantListAdapter.RestaurantListView>() {

    inner class RestaurantListView(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val photoIv: ImageView = itemView.findViewById(R.id.PhotoIv)


        fun setItem(item: Any) {
            itemView.setOnClickListener { adapterOnClick(item) }
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

        val restaurant = list[position]
        GlideApp.with(context)
            .load(restaurant.restaurant.photos?.get(0)?.photo?.url)
            .into(holder.photoIv)
        restaurant.restaurant.photos?.get(0)?.photo?.url?.let { holder.setItem(it) }
    }
}