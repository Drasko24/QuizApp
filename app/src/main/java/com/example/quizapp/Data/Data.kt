package com.example.quizapp.Data

import com.example.quizapp.Model.Question
import com.example.quizapp.R

object Data {

    // Imam potrebnu Data-u koju moram prikazati na ekranu.
    val questions : MutableList<Question> = mutableListOf(
        Question(1,"What country does this flag belong to?", R.drawable.ic_flag_of_argentina,"Argentina","Brasil","Honduras","Equador",1),
        Question(2,"What country does this flag belong to?", R.drawable.ic_flag_of_australia,"Brasil","Australia","Montenegro","Serbia",2),
        Question(3,"What country does this flag belong to?", R.drawable.ic_flag_of_belgium,"Fiji","Brasil","Honduras","Belgium",4),
        Question(4,"What country does this flag belong to?", R.drawable.ic_flag_of_brazil,"San Salvador","Brasil","Honduras","Equador",2),
        Question(5,"What country does this flag belong to?", R.drawable.ic_flag_of_denmark,"Belgium","Brasil","Honduras","Denmark",4),
        Question(6,"What country does this flag belong to?", R.drawable.ic_flag_of_fiji,"Sao Tome and Principe","Brasil","Fiji","Equador",3),
        Question(7,"What country does this flag belong to?", R.drawable.ic_flag_of_germany,"Germany","Brasil","Honduras","Equador",1),
        Question(8,"What country does this flag belong to?", R.drawable.ic_flag_of_india,"Kongo","India","Honduras","Equador",2),
        Question(9,"What country does this flag belong to?", R.drawable.ic_flag_of_kuwait,"Qatar","Brasil","Kuwait","Equador",3),
        Question(1,"What country does this flag belong to?", R.drawable.ic_flag_of_new_zealand,"Australia","New Zealand","Honduras","Equador",2)
            )
}