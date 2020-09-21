package com.example.android.demofocusbug

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.tab_layout.*

class TabFragment(private val number: Int): Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.tab_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        text.setText(number.toString())

        text.setOnFocusChangeListener { _, hasFocus ->
            Toast.makeText(context, "Focus is: $hasFocus", Toast.LENGTH_SHORT).show()
        }
    }
}