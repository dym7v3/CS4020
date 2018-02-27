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
    var my_score: Int =0



    //The initiation block.
    init {
        v.add(generate_random_color())
        //v.add(generate_random_color()) //TODO eventually don't allow for the same color to be shown after each other.
        size_of_vector = 1
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

    private fun add_one_to_pattern()
    {
        v.add(generate_random_color())
        size_of_vector++
    }

    fun get_game_ready()
    {
        current_pos=0
        add_one_to_pattern()
    }
    fun got_it_right()
    {
        current_pos++
        my_score++
        if(my_score>high_score)
        {
            high_score=my_score
        }
    }


}
