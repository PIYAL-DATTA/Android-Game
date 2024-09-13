package com.example.game

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Rect
import com.example.game.R

class Bird internal constructor(res: Resources?) {
    @JvmField
    var speed = 23
    @JvmField
    var wasShot = true
    @JvmField
    var x = 0
    @JvmField
    var y: Int
    @JvmField
    var width: Int
    @JvmField
    var height: Int
    var flag = 1
    var bird1: Bitmap
    var bird2: Bitmap
    val bird: Bitmap
        get() {
            if (flag == 1) {
                flag++
                return bird1
            }
            flag = 1
            return bird2
        }
    val collisionShape: Rect
        get() = Rect(x, y, x + width, y + height)

    init {
        bird1 = BitmapFactory.decodeResource(res, R.drawable.upper)
        bird2 = BitmapFactory.decodeResource(res, R.drawable.upper2)
        width = bird1.width
        height = bird1.height
        width /= 2
        height /= 2
        width = (width * View.screenRatioX).toInt()
        height = (height * View.screenRatioY).toInt()
        bird1 = Bitmap.createScaledBitmap(bird1, width, height, false)
        bird2 = Bitmap.createScaledBitmap(bird2, width, height, false)
        y = -height
    }
}