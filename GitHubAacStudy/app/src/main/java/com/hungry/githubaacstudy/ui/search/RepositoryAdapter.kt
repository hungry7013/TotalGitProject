package com.hungry.githubaacstudy.ui.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hungry.githubaacstudy.R
import com.hungry.githubaacstudy.databinding.RowBuildingObjBinding
import com.hungry.githubaacstudy.ui.BindingViewHolder
import com.hungry.githubaacstudy.ui.networktest.ResVOApiPlosResponseDocs

/**
 * @author Leopold
 */
class RepositoryAdapter(
    var items: List<ResVOApiPlosResponseDocs> = arrayListOf(),
    val vm: SearchViewModel
) :
    RecyclerView.Adapter<RepositoryAdapter.RepositoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        return RepositoryViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.row_building_obj,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        holder.binding.item = items[position]
        holder.binding.viewModel = vm
    }

    override fun getItemCount() = items.size
    class RepositoryViewHolder(view: View) : BindingViewHolder<RowBuildingObjBinding>(view)
}