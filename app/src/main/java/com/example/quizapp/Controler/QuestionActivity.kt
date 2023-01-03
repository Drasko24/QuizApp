package com.example.quizapp.Controler

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toDrawable
import com.example.quizapp.Data.Data
import com.example.quizapp.Extras.CORRECT
import com.example.quizapp.Extras.PLAYER_NAME
import com.example.quizapp.Model.Question
import com.example.quizapp.R
import kotlinx.android.synthetic.main.activity_question.*
import org.w3c.dom.Text

class QuestionActivity : AppCompatActivity(),View.OnClickListener {
    // Ovdje dodajemo View.OnClickListener kako bi omoogucili da UI elementi budu 'clickable'
    var corectAnswers = 0
    private var player : String ?= null
    val questionList = Data.questions
    var currentPosition = 1
    // Globalno deklarisem ove promjenlive(da se mogu bilo gdje unutar ove klase koristiti)
    var selectedOptionPosition = 0 // Ova promjenljiva je da znamo koji odgovor je izabran, jer
    // zelimo da uporedimo ovo sa correctAnswer varijablom koju ima svaka instanca Question klase.
    // Stavili smo da je vrijednost 0, a vrijednost moze biti 1,2,3,4 (to su moguci odgovori), i tu vrijednost kasnije korigujemo
    var selectionTester = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
        player = intent.getStringExtra(PLAYER_NAME)
        //println(player)
        setQuestion()

        firstOptionn.setOnClickListener(this)
        secondOptionn.setOnClickListener(this)
        thirdOptionn.setOnClickListener(this)
        fourthOptionn.setOnClickListener(this)
        submitBtn.setOnClickListener(this)



    }

    private fun setQuestion() {
        setDefaultOptionsView()
        var question = questionList[currentPosition - 1]
        progressBar.progress = currentPosition
        progressText.text = "${currentPosition}/${progressBar.max}"
        firstOptionn.text = question.firstOption
        secondOptionn.text = question.secondOption
        thirdOptionn.text = question.thirdOption
        fourthOptionn.text = question.fourthOption
        flagImage.setImageResource(question.image)

        if (currentPosition==questionList.size){
            submitBtn.text = "FINISH"
        }else{
            submitBtn.text = "SUBMIT"
        }
    }

    // Method koji nam sluzi da sve opcije poprime defaultan izgled.
    fun setDefaultOptionsView(){
        val options = ArrayList<TextView>()
        firstOptionn.let {
            options.add(0,it)
        }
        secondOptionn.let {
            options.add(1,it)
        }
        thirdOptionn.let {
            options.add(2,it)
        }
        fourthOptionn.let {
            options.add(3,it)
        }
        // Moram ovako da dodajem TextView-ove jer mogu biti null, i ne dozvoljava na drugi nacin.

        // Prolazimo kroz sve textView-ove, tj ponudjene opcije u nasoj aplikaciji i setujemo im
        // vrstu slova i background
        for (i in  options){
            i.setTextColor(Color.parseColor("#7A8089"))
            i.typeface = Typeface.DEFAULT
            i.background = ContextCompat.getDrawable(this,R.drawable.button_normal_appearance)
        }

    }

    // Method koji nam pravi selectovan izgled neke od opcija kada na nju kliknemo
    fun setSelectedOptionView(tv:TextView,selectedOptionNum: Int){
        // Ovi argumenti unutar funkcije su da znamo koji textView je selectovan a drugi je da znamo poziciju selectovane opcije
        setDefaultOptionsView() // Prvo setujemo sve na normal appearance

        selectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#FFFFFF"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this, R.drawable.selected_button_appearance)

    }


    override fun onClick(view: View?) {
        // Funkcija koja se po automatizmu dodaje kada klasi dodamo onClickListener.

        when(view?.id){
            R.id.firstOptionn -> setSelectedOptionView(firstOptionn,1)
            R.id.secondOptionn -> setSelectedOptionView(secondOptionn,2)
            R.id.thirdOptionn -> setSelectedOptionView(thirdOptionn,3)
            R.id.fourthOptionn -> setSelectedOptionView(fourthOptionn,4)

            // Setujemo sada sta se desava sa  submit buttonom kada se klikne na njega

            R.id.submitBtn -> {

                if (selectedOptionPosition != 0 || submitBtn.text == "GO TO NEXT QUESTION") {
                    if (selectedOptionPosition == 0) {
                        currentPosition++

                        when {
                            currentPosition <= questionList.size ->
                                setQuestion()
                        }

                    } else {
                        val question = Data.questions[currentPosition - 1]
                        if (selectedOptionPosition != question.correctAnswer) {
                            answerView(selectedOptionPosition, R.drawable.wrong_answer_appearance)
                        }else{
                            corectAnswers++
                        }

                        answerView(question.correctAnswer, R.drawable.correct_answer_appearance)

                        if (currentPosition == questionList.size) {
                            submitBtn.text= "FINISH"
                        } else {
                            submitBtn.text = "GO TO NEXT QUESTION"

                        }

                        selectedOptionPosition = 0// Nakon sto smo izvrceli pitanje, vracamo na nulu
                        // ovu varijablu, kako bi mogli preci na novo pitanje
                    }
                }else{
                    if (currentPosition!=questionList.size){
                        Toast.makeText(this,"Please select your answer.",Toast.LENGTH_SHORT).show()
                    }else {
                        val intent1 = Intent(this,FinishActivity::class.java)
                        intent1.putExtra(PLAYER_NAME,player)
                        intent1.putExtra(CORRECT,corectAnswers)
                        startActivity(intent1)

                    }

                }
            }
        }
    }
    // Ovo je methoda koja ce da setuje trazeni view, u zavisnosti da li je to tacan ili netacan odgovor
    // A pozivacemo je nakon klika na submit btn
    fun answerView(answer:Int,drawableView: Int){
        when(answer){
            1 -> {
                firstOptionn.background = ContextCompat.getDrawable(this,drawableView)
                firstOptionn.setTextColor(Color.parseColor("#FFFFFF"))
            }
            2 -> {
                secondOptionn.background = ContextCompat.getDrawable(this,drawableView)
                secondOptionn.setTextColor(Color.parseColor("#FFFFFF"))
            }
            3 -> {
                thirdOptionn.background = ContextCompat.getDrawable(this,drawableView)
                thirdOptionn.setTextColor(Color.parseColor("#FFFFFF"))
            }
            4 -> {
                fourthOptionn.background = ContextCompat.getDrawable(this,drawableView)
                fourthOptionn.setTextColor(Color.parseColor("#FFFFFF"))
            }
        }
    }
}