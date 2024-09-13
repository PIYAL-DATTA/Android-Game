package com.example.game

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Rect
import com.example.game.R

class flight internal constructor(private val view: View, screenY: Int, res: Resources?) {
    @JvmField
    var upp = false
    @JvmField
    var toShoot = 0
    @JvmField
    var x: Int
    @JvmField
    var y: Int
    @JvmField
    var width: Int
    @JvmField
    var height: Int
    var shootCounter = 1
    var wing = 0
    var flight1: Bitmap
    var flight2: Bitmap
    var dead: Bitmap
    val flight: Bitmap
        get() {
            if (toShoot != 0) {
                if (shootCounter == 1) {
                    shootCounter++
                    return flight1
                }
                if (shootCounter == 2) {
                    shootCounter++
                    return flight2
                }
                shootCounter = 1
                toShoot--
                view.tobullet()
                return flight1
            }
            if (wing == 0) {
                wing++
                return flight1
            }
            wing--
            return flight2
        }
    val collisionShape: Rect
        get() = Rect(x, y, x + width, y + height)

    init {
        flight1 = BitmapFactory.decodeResource(res, R.drawable.heli1)
        flight2 = BitmapFactory.decodeResource(res, R.drawable.heli2)
        width = flight1.width
        height = flight1.height
        width /= 3
        height /= 3
        width = (width * View.screenRatioX).toInt()
        height = (height * View.screenRatioY).toInt()
        flight1 = Bitmap.createScaledBitmap(flight1, width, height, false)
        flight2 = Bitmap.createScaledBitmap(flight2, width, height, false)
        dead = BitmapFactory.decodeResource(res, R.drawable.gameover)
        dead = Bitmap.createScaledBitmap(dead, 550, 750, false)
        y = screenY / 3
        x = (30 * View.screenRatioX).toInt()
    }

}