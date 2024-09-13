package com.example.game

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class about : AppCompatActivity() {
    lateinit var button1: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        button1 = findViewById(R.id.back)
        button1.setOnClickListener(listen)

    }

    val listen = View.OnClickListener { view ->
        when (view.getId()) {
            R.id.back -> {
                val intent = Intent(this@about, menu1::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}