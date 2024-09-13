package com.example.game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class menu2 : AppCompatActivity() {
    lateinit var button3: Button
    lateinit var button1: Button
    lateinit var button2: Button
    lateinit var button4: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu2)
        button3 = findViewById(R.id.back)
        button3.setOnClickListener(listen)
        button1 = findViewById(R.id.newgame)
        button1.setOnClickListener(listen1)
        button2 = findViewById(R.id.about_game)
        button2.setOnClickListener(listen2)
        button4 = findViewById(R.id.score)
        button4.setOnClickListener(listen4)

    }

    val listen = View.OnClickListener { view ->
        when (view.getId()) {
            R.id.back -> {
                val intent = Intent(this@menu2, menu1::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

    val listen4 = View.OnClickListener { view ->
        when (view.getId()) {
            R.id.score -> {
                val intent = Intent(this@menu2, score::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

    val listen2 = View.OnClickListener { view ->
        when (view.getId()) {
            R.id.about_game -> {
                val intent = Intent(this@menu2, aboutgame::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

    val listen1 = View.OnClickListener { view ->
        when (view.getId()) {
            R.id.newgame -> {
                val intent = Intent(this@menu2, GameActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

    }
}