package com.example.dennismoyseyev.simon
import android.animation.Animator
import android.animation.AnimatorInflater
import android.os.CountDownTimer
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_game.*

var model : gameModel = gameModel(1)

class Game : Activity() {


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        //Grabs the difficultly for the first screen. It is sent when the button is pressed.
        model = gameModel(intent.getIntExtra("difficultly",1))//Create the model to store the data.
        model.high_score=intent.getIntExtra("High_Score",0)
        //Displays the high score which is saved in the data model.
        score.text = model.high_score.toString()

        //This sets on onclick listeners for the four buttons.
        bind_buttons()
        game() //Starts the game the for the first time.
    }

    //The game function. It will be called on create and then after wards by buttons.
    private fun game()
    {
        if(model.gameOver) //When the game is over then it will start a new activity.
        // Which will be taking it to the Results activity.
        {
            //This will delay the time for the Game over message to display after telling the user which button they should have preseed.
            Handler().postDelayed(Runnable {
                Toast.makeText(this@Game, "Game Over!", Toast.LENGTH_SHORT).show()
            }, 2100)
            Toast.makeText(this@Game, "You should have pressed the : \'"+model.get_current_color_at_postion(model.current_pos) + "\' Button", Toast.LENGTH_SHORT).show()
            model.mTimer?.cancel()
            val intent = Intent(this@Game, Results::class.java)
            intent.putExtra("Score",model.my_score) //Sends the Score to the Results screen
            intent.putExtra("High_Score",model.high_score) //Sends the High Score to the Results screen.
            startActivity(intent)

        }
        else //If it is not game over then it will display the sequence of buttons and play game.
        {
            sequenceTriggered()
        }
    }

    //This will have the sequence triggered. This is the code that I got from class.
    //It is modified to and display all the buttons that are in the size of the vector.
     private fun sequenceTriggered()
    {
        var timing: Long= 0
        for (index in 0 until model.size_of_vector)
        {
            var animator: Animator

            when {
                model.difficutly == 1 -> {
                    animator = AnimatorInflater.loadAnimator(this, R.animator.easy_animation)
                    animator.startDelay = ((index + 1) * 750).toLong() //Sets the delay so they run in order.

                }
                model.difficutly==2 -> {
                    animator = AnimatorInflater.loadAnimator(this, R.animator.medium_animation)
                    animator.startDelay = ((index + 1) * 500).toLong() //Sets the delay so they run in order.
                }
                else -> {
                    animator = AnimatorInflater.loadAnimator(this, R.animator.hard_animation)
                    animator.startDelay = ((index + 1) * 350).toLong() //Sets the delay so they run in order.
                }
            }
            model.current_Color=model.get_current_color_at_postion(index)
            val button: Button = when (model.current_Color) //Tells which text to light up.
            {
                BUTTON_COLORS.green -> green_button
                BUTTON_COLORS.yellow -> yellow_button
                BUTTON_COLORS.blue-> blue_button
                BUTTON_COLORS.red-> red_button
            }
            animator.setTarget(button)
            animator.start() //Starts the animator.
        }
        when{
            model.difficutly == 1 ->{timing=31000}
            model.difficutly == 2 ->{timing=21000}
            else->{timing=16000}
        }
       timer(timing)
       model.mTimer?.start()
    }
    private fun timer(timing: Long)
    {
        model.mTimer = object: CountDownTimer(timing, 1000){
            override fun onTick(millisUntilFinished: Long) {
                time.text=(millisUntilFinished / 1000).toString()
            }
            override fun onFinish() {
                model.gameOver=true
                game()
            }
        }
    }


    private fun bind_buttons(){
        blue_button.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                val color = model.get_current_color_at_postion(model.current_pos)
                if (color == BUTTON_COLORS.blue)
                {
                    model.got_it_right()
                    Toast.makeText(this@Game, "You got it!", Toast.LENGTH_SHORT).show()
                    if(model.my_score>= model.high_score)
                        score.text = model.high_score.toString()
                    if (model.current_pos>=model.size_of_vector)
                    {
                        model.get_game_ready()
                        game()
                    }
                }
                else
                {
                    model.gameOver=true
                    game()
                }
            }

        })

        red_button.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?){
                val color = model.get_current_color_at_postion(model.current_pos)
                if (color == BUTTON_COLORS.red)
                {
                    model.got_it_right()
                    Toast.makeText(this@Game, "You got it!", Toast.LENGTH_SHORT).show()
                    if(model.my_score>= model.high_score)
                        score.text = model.high_score.toString()
                    if (model.current_pos>=model.size_of_vector)
                    {
                        model.get_game_ready()
                        game()
                    }
                }
                else
                {
                    model.gameOver=true
                    game()
                }
            }
        })

        green_button.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?){
                val color = model.get_current_color_at_postion(model.current_pos)
                if (color == BUTTON_COLORS.green)
                {
                    model.got_it_right()
                    Toast.makeText(this@Game, "You got it!", Toast.LENGTH_SHORT).show()
                    if(model.my_score>= model.high_score)
                        score.text = model.high_score.toString()
                    if (model.current_pos>=model.size_of_vector)
                    {
                        model.get_game_ready()
                        game()
                    }
                }
                else
                {
                    model.gameOver=true
                    game()
                }
            }
        })
        yellow_button.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?){
                val color = model.get_current_color_at_postion(model.current_pos)
                if (color == BUTTON_COLORS.yellow)
                {
                    model.got_it_right()
                    Toast.makeText(this@Game, "You got it!", Toast.LENGTH_SHORT).show()
                    if(model.my_score>= model.high_score)
                        score.text = model.high_score.toString()
                    if (model.current_pos>=model.size_of_vector)
                    {
                        model.get_game_ready()
                        game()
                    }
                }
                else
                {
                    model.gameOver=true
                    game()
                }
            }
        })
    }

}
