package com.hungry.githubaacstudy.ui.search

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.hungry.githubaacstudy.R
import com.hungry.githubaacstudy.databinding.ActivitySearchBinding
import org.koin.androidx.viewmodel.ext.android.getViewModel

class SearchActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("TEST", "onCreate...")
        binding = DataBindingUtil.setContentView(this, R.layout.activity_search)

        binding.viewModel = getViewModel()
        binding.lifecycleOwner = this



    }
}