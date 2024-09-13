package com.example.game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class splash2 : AppCompatActivity() {
    lateinit var splash2: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash2)

        splash2 = Handler()
        splash2.postDelayed({

            val intent = Intent(this, com.example.game.menu1::class.java)

            startActivity(intent)
            finish()
        },3000)
    }
}