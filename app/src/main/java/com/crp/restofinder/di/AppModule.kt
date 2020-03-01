package com.crp.restofinder.di

import com.crp.restofinder.ActivityRetriever
import com.crp.restofinder.DefaultCurrentActivityListener
import org.koin.dsl.module

val appModule = module {
    single { DefaultCurrentActivityListener() }
    single { ActivityRetriever(get()) }
}