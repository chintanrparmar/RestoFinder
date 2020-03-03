package com.crp.restofinder.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.crp.restofinder.GlideApp
import com.crp.restofinder.R
import kotlinx.android.synthetic.main.activity_restaurant_detail.*

class RestaurantDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant_detail)

        GlideApp.with(this)
            .load(intent.getStringExtra("url"))
            .into(coverIv)
    }
}
