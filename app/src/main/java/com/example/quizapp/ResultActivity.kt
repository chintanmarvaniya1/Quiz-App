package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val userName = intent.getStringExtra(CreateQuestionList.USER_NAME)
        val totalMarks = intent.getIntExtra(CreateQuestionList.TOTAL_QUESTION,0)
        val correctMarks = intent.getIntExtra(CreateQuestionList.CORRECT_ANSWER,0)
        tvUsername.text=userName
        tvScore.text = "Your Score is $correctMarks out of $totalMarks"

        btnFinish.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}