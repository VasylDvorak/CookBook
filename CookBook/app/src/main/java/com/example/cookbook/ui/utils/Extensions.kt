package com.example.cookbook.ui.utils

import android.widget.Toast
import com.example.cookbook.application.App

class Extensions {
        fun showToast(text: String?, length: Int = Toast.LENGTH_LONG) {
            Toast.makeText(App.instance.applicationContext, text, length).show()
        }
}