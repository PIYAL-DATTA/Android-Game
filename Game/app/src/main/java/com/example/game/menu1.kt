package com.example.game

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.content.Intent

class menu1 : AppCompatActivity() {
    lateinit var button1: Button
    lateinit var button2: Button
    lateinit var button3: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu1)
        button1 = findViewById(R.id.startgame)
        button1.setOnClickListener(listener1)
        button2 = findViewById(R.id.about)
        button2.setOnClickListener(listener2)
        button3 = findViewById(R.id.exit)
        button3.setOnClickListener(listener3)
    }

    val listener1= View.OnClickListener { view ->
        when (view.getId()) {
            R.id.startgame -> {
                val intent = Intent(this@menu1, menu2::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

    val listener2 = View.OnClickListener { view ->
        when (view.getId()) {
            R.id.about -> {
                val myIntent = Intent(this@menu1, about::class.java)
                startActivity(myIntent)
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