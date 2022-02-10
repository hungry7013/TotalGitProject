package com.hungry.githubrecyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
    }

    private fun initRecyclerView() {

        val list = ArrayList<RecyclerViewObj>()

        for (i in 1..10) {
            val msgMain = "Title ~!"
            val msgSub = "date ~!"

            list.add(
                RecyclerViewObj(
                    msgMain,
                    msgSub
                )
            )
        }

        recyclerView = findViewById(R.id.recyclerView)

        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = linearLayoutManager

        val adapter = RecyclerViewAdapter()
        adapter.setList(list)
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()
    }
}