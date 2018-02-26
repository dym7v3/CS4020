package com.example.dennismoyseyev.simon

import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import java.util.concurrent.ThreadLocalRandom
import java.util.Vector

enum class BUTTON_COLORS {
    blue, red, green, yellow
}


//Constructor which will be run at the beginning on the program
class gameModel(val difficutly: Int){ //Primary constructor
    private val v = Vector<BUTTON_COLORS>(1)
    var size_of_vector: Int = 0
    var high_score: Int = 0
    var current_pos: Int =0
    val mAnimation: Animation = AlphaAnimation(1f, 0f)



    //The initiation block.
    init {
        v.add(generate_random_color())
        size_of_vector = 1
        mAnimation.duration = (100/difficutly).toLong()
        mAnimation.interpolator = LinearInterpolator()
        mAnimation.repeatCount = (6/difficutly).toInt()
        mAnimation.repeatMode = Animation.REVERSE
    }

    private fun generate_random_color(): BUTTON_COLORS {
        val num = ThreadLocalRandom.current().nextInt(0, 3 + 1)

        return when (num) {
            0 -> BUTTON_COLORS.blue
            1 -> BUTTON_COLORS.red
            2 -> BUTTON_COLORS.green
            3 -> BUTTON_COLORS.yellow
            else //By default it returns blue which is the right button.
            -> BUTTON_COLORS.blue
        }
    }

    internal fun get_current_color_at_postion(p: Int): BUTTON_COLORS {
        return v[p]
    }


}
