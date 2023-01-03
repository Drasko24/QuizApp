package com.example.quizapp.Controler

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.quizapp.Extras.CORRECT
import com.example.quizapp.Extras.PLAYER_NAME
import com.example.quizapp.R
import kotlinx.android.synthetic.main.activity_finish.*
import kotlinx.android.synthetic.main.activity_question.*

class FinishActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)


        playerName.text = intent.getStringExtra(PLAYER_NAME)

        val sc = intent.getIntExtra(CORRECT,0)
        yourScore.text = "Your score is $sc out of 10"
        finishBtn.setOnClickListener(this)


    }

    override fun onClick(p0: View?) {
        val intent2 = Intent(this,MainActivity::class.java)
        startActivity(intent2)
    }
}