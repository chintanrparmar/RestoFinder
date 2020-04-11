package com.crp.restofinder

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.crp.restofinder.utils.GlideApp
import com.crp.restofinder.view.DetailsView
import kotlinx.android.synthetic.main.activity_restaurant_detail.*

class RestaurantDetail : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant_detail)
        DetailsView(restaurantDetail)
    }


}
