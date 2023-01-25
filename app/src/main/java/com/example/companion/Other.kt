package com.example.companion

import android.util.Log

class Other {
    private val data = MainActivity.csvData

    fun log(){
        Log.i("read", data.toList().toString())
    }
}