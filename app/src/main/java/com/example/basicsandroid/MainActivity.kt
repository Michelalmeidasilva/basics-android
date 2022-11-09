package com.example.basicsandroid

import android.app.Activity
import android.os.Bundle
import android.widget.TextView

class MainActivity : Activity() {

    //ciclos de vida
    // 1. onCreate
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
    }

}