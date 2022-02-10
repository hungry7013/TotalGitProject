package com.hungry.githubaacstudy.ui.search

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hungry.githubaacstudy.ui.networktest.ResVOApiPlosResponseDocs

/**
 * @author Leopold
 */
@BindingAdapter(value = ["repositories", "viewModel"])
fun setRepositories(view: RecyclerView, items: List<ResVOApiPlosResponseDocs>, vm: SearchViewModel) {
    view.adapter?.run {
        if (this is RepositoryAdapter) {
            this.items = items
            this.notifyDataSetChanged()
        }
    } ?: run {
        RepositoryAdapter(items, vm).apply { view.adapter = this }
    }
}