package com.hungry.githubfragment

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class Type01Activity : AppCompatActivity() {

    private lateinit var manager: FragmentManager

    private lateinit var fragment01: Fragment
    private lateinit var fragment02: Fragment
    private lateinit var fragment03: Fragment

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

        fragment01 = Sample01Fragment()
        fragment02 = Sample02Fragment()
        fragment03 = Sample03Fragment()

        manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.add(R.id.frameLayout, fragment01)
        transaction.add(R.id.frameLayout, fragment02)
        transaction.add(R.id.frameLayout, fragment03)
        transaction.commit()

        changeFragment001()
    }

    private fun changeFragment001() {
        val transaction = manager.beginTransaction()
        transaction.show(fragment01)
        transaction.hide(fragment02)
        transaction.hide(fragment03)
        transaction.commit()
    }

    private fun changeFragment002() {
        val transaction = manager.beginTransaction()
        transaction.hide(fragment01)
        transaction.show(fragment02)
        transaction.hide(fragment03)
        transaction.commit()
    }

    private fun changeFragment003() {
        val transaction = manager.beginTransaction()
        transaction.hide(fragment01)
        transaction.hide(fragment02)
        transaction.show(fragment03)
        transaction.commit()
    }
}