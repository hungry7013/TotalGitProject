package com.hungry.githubrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    private lateinit var items: ArrayList<RecyclerViewObj>

    fun setList(list: List<RecyclerViewObj>) {
        items = list as ArrayList<RecyclerViewObj>
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_obj, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.mainTextView.text = items[position].msgMain
        holder.subTextView.text = items[position].msgSub
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var mainTextView: TextView = view.findViewById(R.id.mainTextView)
        var subTextView: TextView = view.findViewById(R.id.subTextView)
    }

}
