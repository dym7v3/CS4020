package com.example.dennismoyseyev.simon

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_results.*

class Results : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)
        val high_score=intent.getIntExtra("High_Score", 0)

        //Displays the results for this round.
        Score_box.text = intent.getIntExtra("Score",0).toString()

        //This will save the high score that was passed from the game activity to be passed to the main screen again.
        play_game.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("High_Score",high_score)
            startActivity(intent)
        }
        //When the high score button is pressed it will display a toast with the high score.
        high_score_but.setOnClickListener{
            Toast.makeText(this@Results,"The High Score Is : "+high_score , Toast.LENGTH_SHORT).show()
        }
    }
}
