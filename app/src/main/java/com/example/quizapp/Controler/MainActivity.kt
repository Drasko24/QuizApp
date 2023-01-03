package com.example.quizapp.Controler

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.quizapp.Extras.PLAYER_NAME
import com.example.quizapp.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startBtn.setOnClickListener {
            if (nameTextField.text.isNotEmpty()) {
                val intent = Intent(this, QuestionActivity::class.java)
                intent.putExtra(PLAYER_NAME,nameTextField.text.toString())
                startActivity(intent)

            } else Toast.makeText(this, "Please enter your name.", Toast.LENGTH_SHORT).show()

        }
    }

    }
