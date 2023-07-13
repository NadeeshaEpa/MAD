package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var resultTextView: TextView
    private var operand1: Double = 0.0
    private var operand2: Double = 0.0
    private var operator: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.resultTextView)

        val button0=findViewById<TextView>(R.id.button0)
        val button1=findViewById<TextView>(R.id.button1)
        val button2=findViewById<TextView>(R.id.button2)
        val button3=findViewById<TextView>(R.id.button3)
        val button4=findViewById<TextView>(R.id.button4)
        val button5=findViewById<TextView>(R.id.button5)
        val button6=findViewById<TextView>(R.id.button6)
        val button7=findViewById<TextView>(R.id.button7)
        val button8=findViewById<TextView>(R.id.button8)
        val button9=findViewById<TextView>(R.id.button9)

        val buttonDot=findViewById<TextView>(R.id.buttonDot)
        val buttonPlus=findViewById<TextView>(R.id.buttonAdd)
        val buttonMinus=findViewById<TextView>(R.id.buttonSubtract)
        val buttonMultiply=findViewById<TextView>(R.id.buttonMultiply)
        val buttonDivide=findViewById<TextView>(R.id.buttonDivide)
        val buttonEquals=findViewById<TextView>(R.id.buttonEquals)
        val buttonClear=findViewById<TextView>(R.id.buttonClear)

        button0.setOnClickListener { numberPressed("0") }
        button1.setOnClickListener { numberPressed("1") }
        button2.setOnClickListener { numberPressed("2") }
        button3.setOnClickListener { numberPressed("3") }
        button4.setOnClickListener { numberPressed("4") }
        button5.setOnClickListener { numberPressed("5") }
        button6.setOnClickListener { numberPressed("6") }
        button7.setOnClickListener { numberPressed("7") }
        button8.setOnClickListener { numberPressed("8") }
        button9.setOnClickListener { numberPressed("9") }
        buttonDot.setOnClickListener { numberPressed(".") }

        buttonPlus.setOnClickListener { operatorPressed("+") }
        buttonMinus.setOnClickListener { operatorPressed("-") }
        buttonMultiply.setOnClickListener { operatorPressed("*") }
        buttonDivide.setOnClickListener { operatorPressed("/") }

        buttonEquals.setOnClickListener {
            operand2 = resultTextView.text.toString().toDouble()
            var result: Double = 0.0
            when (operator) {
                "+" -> result = operand1 + operand2
                "-" -> result = operand1 - operand2
                "*" -> result = operand1 * operand2
                //handle divide by zero
                "/" -> result = if (operand2 == 0.0) {
                    Double.NaN
                } else {
                    operand1 / operand2
                }
            }
            resultTextView.text = result.toString()
        }

        buttonClear.setOnClickListener {
            resultTextView.text = ""
            operand1 = 0.0
            operand2 = 0.0
        }
    }

    private fun operatorPressed(s: String) {
        operator = s
        operand1 = resultTextView.text.toString().toDouble()
        resultTextView.text = ""
    }

    private fun numberPressed(s: String) {
        if (resultTextView.text.toString() == "NaN") {
            resultTextView.text = ""
        }
        resultTextView.append(s)
    }
}