package com.example.dennismoyseyev.simon

import android.os.CountDownTimer
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_game.*



class Game : Activity() {
    var difficultly : Int = 1
    var model : gameModel = gameModel(1)
    var current_Color : BUTTON_COLORS = BUTTON_COLORS.blue
    var but: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        difficultly = intent.getIntExtra("difficultly",1)
        model = gameModel(difficultly)
        score.setText(model.high_score.toString())
        bind_buttons()
        game()

    }

    private fun game()
    {
            for (index in 0 until model.size_of_vector){
                current_Color=model.get_current_color_at_postion(index)
                light_up_button()
            }
            object: CountDownTimer(10000, 1000){
                override fun onTick(millisUntilFinished: Long) {
                    time.setText(""+ millisUntilFinished / 1000)
                }

                override fun onFinish() {

                }
            }.start()


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

    private fun bind_buttons(){
        blue_button.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                val color = model.get_current_color_at_postion(model.current_pos)
                if (color == BUTTON_COLORS.blue)
                {
                    model.current_pos++
                    Toast.makeText(this@Game, "You got it!", Toast.LENGTH_SHORT).show()
                }
                else
                {
                    val intent = Intent(this@Game, Results:: class.java)
                    intent.putExtra("score", 9)
                    startActivity(intent)
                }

            }

        })

        red_button.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?){
                val color = model.get_current_color_at_postion(model.current_pos)
                if (color == BUTTON_COLORS.red)
                {
                    model.current_pos++
                    Toast.makeText(this@Game, "You got it!", Toast.LENGTH_SHORT).show()
                }
                else
                {
                    val intent = Intent(this@Game, Results:: class.java)
                    intent.putExtra("score", 9)
                    startActivity(intent)
                }
            }
        })

        green_button.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?){
                val color = model.get_current_color_at_postion(model.current_pos)
                if (color == BUTTON_COLORS.green)
                {
                    model.current_pos++
                    Toast.makeText(this@Game, "You got it!", Toast.LENGTH_SHORT).show()
                }
                else
                {
                    val intent = Intent(this@Game, Results:: class.java)
                    intent.putExtra("score", 9)
                    startActivity(intent)
                }
            }
        })
        yellow_button.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?){
                val color = model.get_current_color_at_postion(model.current_pos)
                if (color == BUTTON_COLORS.yellow)
                {
                    model.current_pos++
                    Toast.makeText(this@Game, "You got it!", Toast.LENGTH_SHORT).show()
                }
                else
                {
                    val intent = Intent(this@Game, Results:: class.java)
                    intent.putExtra("score", 9)
                    startActivity(intent)
                }
            }
        })
    }


}
