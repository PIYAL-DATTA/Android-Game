package com.example.game

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.ImageView
import com.example.game.R

class back_ground internal constructor(screenX: Int, screenY: Int, res: Resources?) {


    @JvmField
    var x = 0
    @JvmField
    var y = 0
    @JvmField
    var back: Bitmap



    init {
        back = BitmapFactory.decodeResource(res, R.drawable.dp16)
        back = Bitmap.createScaledBitmap(back, screenX, screenY, false)
    }

}