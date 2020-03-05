package com.crp.restofinder.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import com.crp.restofinder.GlideApp
import com.crp.restofinder.R
import kotlinx.android.synthetic.main.activity_restaurant_detail.*

class RestaurantDetail : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant_detail)

        restNameTv.text = intent.getStringExtra("name")
        cuisineTv.text = intent.getStringExtra("cuisine")
        ratingTv.text = getString(R.string.rating, intent.getStringExtra("rating"))

        GlideApp.with(this)
            .load(intent.getStringExtra("url"))
            .into(coverIv)

        backIv.setOnClickListener { finish() }

    }


}
