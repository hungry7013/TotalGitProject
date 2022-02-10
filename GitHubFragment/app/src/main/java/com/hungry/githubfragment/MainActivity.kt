package com.hungry.githubfragment

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hungry.githubfragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnReplace.setOnClickListener {
            val intent = Intent(this, Type02Activity::class.java)
            startActivity(intent)
        }
        binding.btnShowHide.setOnClickListener {
            val intent = Intent(this, Type01Activity::class.java)
            startActivity(intent)
        }

    }
}