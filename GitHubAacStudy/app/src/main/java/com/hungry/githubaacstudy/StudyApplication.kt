package com.hungry.githubaacstudy

import android.app.Application
import com.hungry.githubaacstudy.di.ViewModelModule
import com.hungry.githubaacstudy.di.NetworkModule
import com.hungry.githubaacstudy.di.apiModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

@Suppress("Unused")
class StudyApplication : Application() {

    override fun onCreate() {
        super.onCreate()


        // Koin Start
        startKoin {
            androidContext(this@StudyApplication)

            // use Android logger - Level.INFO by default
            androidLogger()

            modules(
                NetworkModule,
                apiModule,
                ViewModelModule
            )  // 사용할 Module 등록
        }

        // 복수개(여러개) 모듈 등록 시
        // modules(a_Module, b_Module, c_Module)

    }
}