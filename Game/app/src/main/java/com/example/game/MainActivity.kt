package com.example.game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class MainActivity : AppCompatActivity() {
    lateinit var splash: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        splash = Handler()
        splash.postDelayed({

            val intent = Intent(this, splash2::class.java)

            startActivity(intent)
            finish()
        }, 3000)
    }
}