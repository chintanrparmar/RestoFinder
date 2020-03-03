package com.crp.restofinder.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.crp.restofinder.R
import kotlinx.android.synthetic.main.activity_restaurant_list.*

class RestaurantList : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant_list)
        SearchResponseView(restListLayout)
        Toast.makeText(
            applicationContext,
            "Kuch to ${intent.getStringExtra("city")}",
            Toast.LENGTH_SHORT
        ).show()
    }
}
