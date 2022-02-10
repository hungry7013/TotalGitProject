package com.hungry.githubfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Type02Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        (findViewById<Button>(R.id.btnFragment01)).setOnClickListener {
            changeFragment001()
        }
        (findViewById<Button>(R.id.btnFragment02)).setOnClickListener {
            changeFragment002()
        }
        (findViewById<Button>(R.id.btnFragment03)).setOnClickListener {
            changeFragment003()
        }

        changeFragment001()
    }

    private fun changeFragment001() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frameLayout, Sample01Fragment())
        transaction.commit()
    }

    private fun changeFragment002() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frameLayout, Sample02Fragment())
        transaction.commit()
    }

    private fun changeFragment003() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frameLayout, Sample03Fragment())
        transaction.commit()
    }
}