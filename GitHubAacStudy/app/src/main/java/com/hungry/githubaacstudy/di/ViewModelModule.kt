package com.hungry.githubaacstudy.di

import com.hungry.githubaacstudy.ui.search.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val ViewModelModule = module {
    viewModel { SearchViewModel(get()) }
//    viewModel { SearchViewModel() }


}