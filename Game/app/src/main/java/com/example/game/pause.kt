package com.example.game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class pause : AppCompatActivity() {

    lateinit var button1: Button
    lateinit var button2: Button
    lateinit var button3: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pause)

        button1 = findViewById(R.id.resume)
        button1.setOnClickListener(listen1)
        button2 = findViewById(R.id.back)
        button2.setOnClickListener(listen)
        button3 = findViewById(R.id.exit)
        button3.setOnClickListener(listener3)
    }
    val listen = View.OnClickListener { view ->
        when (view.getId()) {
            R.id.back -> {
                val intent = Intent(this@pause, menu2::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

    val listen1 = View.OnClickListener { view ->
        when (view.getId()) {
            R.id.resume -> {
                com.example.game.View.setFaruk(false)
                val intent = Intent(this@pause, GameActivity::class.java)
                startActivity(intent)
                finish()

            }
        }
    }

    val listener3 = View.OnClickListener { view ->
        when (view.getId()) {
            R.id.exit -> {
                moveTaskToBack(true)
                android.os.Process.killProcess(android.os.Process.myPid())
                System.exit(1)
            }
        }
    }

}