package com.example.game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class score : AppCompatActivity() {

    lateinit var score : TextView
    lateinit var button3: Button
    var scr = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        score = findViewById(R.id.score)
        if (com.example.game.View.getscorevalue() > scr)
        {
            scr = com.example.game.View.getscorevalue()
        }

        score.setText("SCORE : " + scr);
        button3 = findViewById(R.id.back)
        button3.setOnClickListener(listen)
    }
    val listen = View.OnClickListener { view ->
        when (view.getId()) {
            R.id.back -> {
                val intent = Intent(this@score, menu1::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}