package com.example.companion

import android.util.Log

class Other2 {

    private val data = MainActivity.csvTest

    fun log(){
        Log.i("read", data?.toList().toString())
    }
}