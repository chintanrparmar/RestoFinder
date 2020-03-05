package com.crp.restofinder.utils

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater

class ActivityRetriever(val defaultCurrentActivityListener: DefaultCurrentActivityListener) {

    val layoutInflater: LayoutInflater =
        LayoutInflater.from(defaultCurrentActivityListener.currentActivity)

    val context: Context = defaultCurrentActivityListener.context

    fun getActivity(): Activity? {
        return defaultCurrentActivityListener.currentActivity
    }
}