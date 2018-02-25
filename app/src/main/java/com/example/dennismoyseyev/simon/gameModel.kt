package com.example.dennismoyseyev.simon

import java.util.concurrent.ThreadLocalRandom
import java.util.Vector

import com.example.dennismoyseyev.simon.gameModel.BUTTON_COLORS.blue
import com.example.dennismoyseyev.simon.gameModel.BUTTON_COLORS.green
import com.example.dennismoyseyev.simon.gameModel.BUTTON_COLORS.red
import com.example.dennismoyseyev.simon.gameModel.BUTTON_COLORS.yellow

class gameModel//Constructor which will be run at the beginning on the program
internal constructor(d: Int) {
    private val v = Vector<BUTTON_COLORS>(4)
    var postion_in_vector: Int = 0
    private var difficutly: Int = 0


    internal enum class BUTTON_COLORS {
        blue, red, green, yellow
    }

    init {
        v.add(generate_random_color())
        postion_in_vector = 0
        setDifficutly(d)
    }

    private fun generate_random_color(): BUTTON_COLORS {
        val num = ThreadLocalRandom.current().nextInt(0, 3 + 1)

        when (num) {
            0 -> return blue
            1 -> return red
            2 -> return green
            3 -> return yellow
            else //By default it returns blue which is the right button.
            -> return blue
        }
    }

    fun get_current_color_at_postion(p: Int): BUTTON_COLORS {
        return v[p]
    }

    private fun setDifficutly(difficutly: Int) {
        this.difficutly = difficutly
    }

}
