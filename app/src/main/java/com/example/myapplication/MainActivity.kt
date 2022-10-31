package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    private lateinit var resultTextView: TextView

    private var operand = 0.0
    private var operation = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.resultTextView)
    }


    fun numberClick(clickedView: View){

        if(clickedView is TextView){
            var text = resultTextView.text.toString()
            val number = clickedView.text.toString()

            if(text == "0"){
                text = ""
            }
            val result = text + number
            resultTextView.text = result
        }
    }

    fun operationClick(clickedView: View){
        if(clickedView is TextView){
            operand = resultTextView.text.toString().toDouble()
            operation = clickedView.text.toString()

            resultTextView.text = ""
        }

    }
    fun allClearClick(clickedView: View){
        if(clickedView is TextView) {
            resultTextView.text = ""
            clickedView.text = ""
        }
    }


    fun delClick(clickedView: View){
        val length = resultTextView.length()
        if (length > 0){
            resultTextView.text = resultTextView.text.subSequence(0, length - 1)
        }else{
            resultTextView.text = "0"
        }
    }


    fun  equalsClick(clickedView: View) {
        val secOperand = resultTextView.text.toString().toDouble()
        when (operation) {
            "+" -> resultTextView.text = (operand + secOperand).toString()
            "-" -> resultTextView.text = (operand - secOperand).toString()
            "*" -> resultTextView.text = (operand * secOperand).toString()
            "/" -> resultTextView.text = (operand / secOperand).toString()

        }

    }
}