package com.crp.restofinder.di

import com.crp.restofinder.utils.ActivityRetriever
import com.crp.restofinder.utils.DefaultCurrentActivityListener
import org.koin.dsl.module

val appModule = module {
    single { DefaultCurrentActivityListener() }
    single { ActivityRetriever(get()) }
}