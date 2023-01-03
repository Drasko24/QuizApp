package com.example.quizapp.Model

data class Question(
    val id: Int,
    val question: String,
    val image: Int,
    val firstOption: String,
    val secondOption: String,
    val thirdOption: String,
    val fourthOption: String,
    val correctAnswer: Int)
//Pravimo klasu, blueprint, kako ce izgledati nasa pitanja.
