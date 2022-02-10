package com.hungry.githubaacstudy.di

import com.google.gson.GsonBuilder
import com.hungry.githubaacstudy.BuildConfig
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * @author Leopold
 */
private const val CONNECT_TIMEOUT = 15L
private const val WRITE_TIMEOUT = 15L
private const val READ_TIMEOUT = 15L

val NetworkModule = module {

    single { Cache(androidApplication().cacheDir, 10L * 1024 * 1024) }

    single { GsonBuilder().create() }

    /*single {
        Interceptor { chain ->
            chain.proceed(chain.request().newBuilder().apply {
                header("Content-Type", "application/x-www-form-urlencoded")
            }.build())
        }
    }*/

    single {
        OkHttpClient.Builder().apply {
            cache(get())
            connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
            readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            retryOnConnectionFailure(true)
            /*addInterceptor(get())*/
            addInterceptor(Interceptor { chain ->
                chain.proceed(chain.request().newBuilder().apply {
//                    header("Content-Type", "application/x-www-form-urlencoded")
                    header("Content-Type", "application/json")
                }.build())
            })
            addInterceptor(HttpLoggingInterceptor().apply {
                if (BuildConfig.DEBUG) {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            })
        }.build()
    }

    single {
        Retrofit.Builder()
//            .baseUrl("https://api.github.com")
//            .baseUrl("https://m.kr.ajunews.com/")
            .baseUrl("https://api.plos.org/")   // https://api.plos.org/search?q=title:DNA
            .addConverterFactory(GsonConverterFactory.create(get()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(get())
            .build()
    }

}
