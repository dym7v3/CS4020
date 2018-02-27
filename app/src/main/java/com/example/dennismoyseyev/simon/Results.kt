package com.example.dennismoyseyev.simon

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_results.*

class Results : Activity() {
    var score: Int=0
    var my_high_score: Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)
        score =intent.getIntExtra("Score",0)
        my_high_score= intent.getIntExtra("High_Score", 0)

        Score_box.text = score.toString()
        play_game.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("High_Score",my_high_score)
            startActivity(intent)
        }
        high_score_but.setOnClickListener{
            Toast.makeText(this@Results,"The High Score Is : "+my_high_score.toString() , Toast.LENGTH_SHORT).show()
        }
    }
}
