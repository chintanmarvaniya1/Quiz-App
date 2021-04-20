package com.example.quizapp

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_question_list.*

class QuestionList : AppCompatActivity() , View.OnClickListener {

    private var currPosition : Int =1
    private var questionList : ArrayList<Question>?=null
    private var selectedOption : Int =0
    private var correctAns : Int =0
    private var userName :String? =null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_list)
        userName=intent.getStringExtra(CreateQuestionList.USER_NAME)

        questionList=CreateQuestionList.getQuestionList()

        setQuestion()

        tvoptionOne.setOnClickListener(this)
        tvoptionTwo.setOnClickListener(this)
        tvoptionThree.setOnClickListener(this)
        tvoptionFour.setOnClickListener(this)
        btnNext.setOnClickListener(this)


    }

    override fun onClick(v: View?) {

        when (v?.id) {
            R.id.tvoptionOne -> {
                selectedOptions(tvoptionOne, 1)
            }
            R.id.tvoptionTwo -> {
                selectedOptions(tvoptionTwo, 2)
            }
            R.id.tvoptionThree -> {
                selectedOptions(tvoptionThree, 3)
            }
            R.id.tvoptionFour -> {
                selectedOptions(tvoptionFour, 4)
            }
            R.id.btnNext ->{

                if(selectedOption == 0){
                    currPosition = currPosition+1

                    when{
                        currPosition <= questionList!!.size ->{
                            setQuestion()

                        }else ->{
                            val intent = Intent(this,ResultActivity::class.java)
                            intent.putExtra(CreateQuestionList.USER_NAME,userName)
                            intent.putExtra(CreateQuestionList.CORRECT_ANSWER,correctAns)
                            intent.putExtra(CreateQuestionList.TOTAL_QUESTION,questionList!!.size)
                            startActivity(intent)
                        }
                    }
                }else{
                    val que =questionList!!.get(currPosition-1)

                    if (que.correctOption != selectedOption){
                        answerView(selectedOption,R.drawable.wrongoptionbar)
                    }else{
                        correctAns++
                    }
                    answerView(que.correctOption,R.drawable.correctoptionbar)

                    if (currPosition==questionList!!.size){
                        btnNext.text=getString(R.string.finish)
                    }else{
                        btnNext.text=getString(R.string.next_question)
                    }

                    selectedOption=0
                }

            }
        }

    }

    private fun answerView(answer:Int, drawableView : Int){

        when(answer){
            1 ->{
                tvoptionOne.background=ContextCompat.getDrawable(this,drawableView)
            }
            2 ->{
                tvoptionTwo.background=ContextCompat.getDrawable(this,drawableView)
            }
            3 ->{
                tvoptionThree.background=ContextCompat.getDrawable(this,drawableView)
            }
            4 ->{
                tvoptionFour.background=ContextCompat.getDrawable(this,drawableView)
            }
        }
    }



    private fun setQuestion(){
        val question = questionList!![currPosition - 1]

        defaultOptions()

        if (currPosition==questionList!!.size){
            btnNext.text=getString(R.string.finish)
        }else{
            btnNext.text=getString(R.string.submit)
        }


        pbTrack.progress = currPosition
        tvTrack.text = "$currPosition" + "/" + pbTrack.max

        tvQuestion.text = question.question
        ivImage.setImageResource(question.image)
        tvoptionOne.text = question.optionOne
        tvoptionTwo.text = question.optionTwo
        tvoptionThree.text = question.optionThree
        tvoptionFour.text = question.optionFour
    }


    private fun defaultOptions(){
        val options = ArrayList<TextView>()
        options.add(0, tvoptionOne)
        options.add(1, tvoptionTwo)
        options.add(2, tvoptionThree)
        options.add(3, tvoptionFour)

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this,R.drawable.optionbar )
        }
    }

    private fun selectedOptions(tv:TextView,selectedOptionNo : Int){

        defaultOptions()

        selectedOption = selectedOptionNo

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this, R.drawable.selectedoptionbar)
    }

}
