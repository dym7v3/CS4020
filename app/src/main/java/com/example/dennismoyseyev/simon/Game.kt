package com.example.dennismoyseyev.simon

import android.app.Activity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_game.*



class Game : Activity() {
    var difficultly : Int = 1
    var model : gameModel = gameModel(1)
    var current_Color : BUTTON_COLORS = BUTTON_COLORS.blue


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        difficultly = intent.getIntExtra("difficultly",1)
        model = gameModel(difficultly)
        score.setText(model.high_score.toString())
        light_up_button()

    }


    private fun light_up_button()
    {
        var select = blue_button
        when (current_Color) {
            BUTTON_COLORS.blue -> select=blue_button
            BUTTON_COLORS.red -> select=red_button
            BUTTON_COLORS.green-> select=green_button
            BUTTON_COLORS.yellow -> select=yellow_button
        }
        select.startAnimation(model.mAnimation)
    }


}
