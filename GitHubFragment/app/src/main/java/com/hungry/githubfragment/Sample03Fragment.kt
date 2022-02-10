package com.hungry.githubfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class Sample03Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_03, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val txtCount = view.findViewById<TextView>(R.id.txtCount)
        txtCount.text = 0.toString()

        (view.findViewById<Button>(R.id.btnPlus)).setOnClickListener {
            val countIntText = Integer.parseInt(txtCount.text as String) + 1
            txtCount.text = countIntText.toString()
        }
    }

}