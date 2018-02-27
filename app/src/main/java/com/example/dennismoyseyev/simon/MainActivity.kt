package com.example.dennismoyseyev.simon

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_game.*

//to convert a Java class into kotlin do. crtl + alt + shift + k.


class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val high_score = intent.getIntExtra("High_Score",0)

        //this will takes us to the Game page when the easy difficultly is pressed.
        easy1.setOnClickListener{
            val intent = Intent(this, Game::class.java)
            intent.putExtra("difficultly", 1)
            intent.putExtra("High_Score",high_score)//Passes the high score.
            startActivity(intent)
        }
        //This will takes us to the Game page when the medium difficultly is pressed.
        med2.setOnClickListener{
            val intent = Intent(this, Game::class.java)
            intent.putExtra("difficultly", 2)
            intent.putExtra("High_Score",high_score) // Passes the high score.
            startActivity(intent)
        }
        //This will takes to the game part when the Hard Button is pressed.
        hard3.setOnClickListener{
            val intent = Intent(this, Game::class.java)
            intent.putExtra("difficultly",3)
            intent.putExtra("High_Score",high_score) //Pass the high score.
            startActivity(intent)
        }
    }

}
