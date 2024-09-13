package com.example.game

import android.content.Intent
import android.graphics.Point
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.VideoView

class GameActivity : AppCompatActivity() {
    private var gameView: View? = null
    lateinit var song: MediaPlayer


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        val point = Point()
        windowManager.defaultDisplay.getSize(point)
        gameView = View(this, point.x, point.y)
        setContentView(gameView)
        song = MediaPlayer.create(this@GameActivity, R.raw.ezo)
        song.start()
        song.setLooping(true)
        if (View.getFaruk() == true)
        {
            val intent = Intent(this@GameActivity, pause::class.java)
            startActivity(intent)
            finish()
        }

    }

    override fun onPause() {
        super.onPause()
        gameView!!.pause()
    }

    override fun onResume() {
        super.onResume()
        gameView!!.resume()
    }


}