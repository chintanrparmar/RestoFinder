package com.crp.restofinder

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.crp.restofinder.utils.GlideApp
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
