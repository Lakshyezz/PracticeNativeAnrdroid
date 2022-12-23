package com.example.lesgo

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random as Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        assignNumbersToButtons()
        btnLeft.setOnClickListener{
            checkAnswer(true)
            assignNumbersToButtons()
        }
        btnRight.setOnClickListener {
            checkAnswer(false)
            assignNumbersToButtons()
    }

    }
    private fun checkAnswer(isLeftButtonSelected: Boolean){
        val ok = 4;
        val leftNum =  btnLeft.text.toString().toInt()
        val rightNum = btnRight.text.toString().toInt()
        val isAnswerCorrect = if(isLeftButtonSelected) leftNum>rightNum else rightNum> leftNum
        if(isAnswerCorrect){
            // correct
            backgroundView.setBackgroundColor(Color.GREEN)
            Toast.makeText(this,"Correct!!", Toast.LENGTH_SHORT).show()
        }
        else{
            // wrong answer
            backgroundView.setBackgroundColor(Color.RED)
            Toast.makeText(this,"Wrong!!", Toast.LENGTH_SHORT).show()
        }
    }
    private fun assignNumbersToButtons() {
       val r = Random
        val leftNum = r.nextInt(10)
        var rightNum = r.nextInt(10)
        while(rightNum == leftNum) rightNum = r.nextInt(10)
        btnLeft.setText(leftNum.toString())
        btnRight.setText(rightNum.toString())
    }
}