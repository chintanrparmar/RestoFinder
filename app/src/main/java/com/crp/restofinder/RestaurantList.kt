package com.crp.restofinder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.crp.restofinder.view.SearchResponseView
import kotlinx.android.synthetic.main.activity_restaurant_list.*

class RestaurantList : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant_list)
        val locality = intent.getStringExtra("location")
        SearchResponseView(restListLayout, locality!!)
    }
}
