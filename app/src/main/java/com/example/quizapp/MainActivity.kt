package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) 

        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN

        btn_Start.setOnClickListener {
            if (etName.text.toString().isEmpty())
                Toast.makeText(this, "Please Enter Your Name", Toast.LENGTH_SHORT).show()
            else{
                val intent = Intent(this,QuestionList::class.java)
                intent.putExtra(CreateQuestionList.USER_NAME,etName.text.toString())
                startActivity(intent)
                finish()
            }
        }

    }
}