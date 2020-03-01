package com.crp.restofinder.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.crp.restofinder.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        LocationResponseView(mainLayout)
        //SearchResponseView(mainLayout)
    }
}
