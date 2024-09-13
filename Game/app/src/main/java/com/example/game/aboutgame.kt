package com.example.game

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class aboutgame : AppCompatActivity() {

    lateinit var button3: Button
    lateinit var song: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aboutgame)

        button3 = findViewById(R.id.back)
        button3.setOnClickListener(listen)

        song = MediaPlayer.create(this@aboutgame, R.raw.helicopter)
        song.start()
        song.setLooping(true)

    }

    val listen = View.OnClickListener { view ->
        when (view.getId()) {
            R.id.back -> {
                song.stop()
                val intent = Intent(this@aboutgame, menu1::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}