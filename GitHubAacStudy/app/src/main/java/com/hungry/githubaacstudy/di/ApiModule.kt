package com.hungry.githubaacstudy.di

import com.hungry.githubaacstudy.ui.networktest.SearchAPI
import org.koin.dsl.module
import retrofit2.Retrofit

/**
 * @author Leopold
 */
val apiModule = module {
    single(createdAtStart = false) { get<Retrofit>().create(SearchAPI::class.java) }
}