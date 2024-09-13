package com.example.game

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Rect
import com.example.game.R

class bullet internal constructor(res: Resources?) {
    @JvmField
    var x = 0
    @JvmField
    var y = 0
    var width: Int
    var height: Int
    @JvmField
    var bullett: Bitmap
    val collisionShape: Rect
        get() = Rect(x, y, x + width, y + height)

    init {
        bullett = BitmapFactory.decodeResource(res, R.drawable.bullet)
        width = bullett.width
        height = bullett.height
        width /= 35
        height /= 35
        width = (width * View.screenRatioX).toInt()
        height = (height * View.screenRatioY).toInt()
        bullett = Bitmap.createScaledBitmap(bullett, width, height, false)
    }
}