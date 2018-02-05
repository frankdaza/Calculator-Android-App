package com.frankdaza.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.frankdaza.calculator.control.service.CalculatorService
import kotlinx.android.synthetic.main.activity_main.*
import java.math.BigDecimal

class MainActivity : AppCompatActivity() {

    private val calculatorService: CalculatorService = CalculatorService()
    private var oldNumber: String = "0"
    private var newNumber: String = "0"
    private var operator: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnNumberEvent(view: View) {
        val btnSelected: Button = view as Button
        var btnClickValue: String = edtResult.text.toString()

        if (btnClickValue.equals("0"))
            btnClickValue = ""

        when (btnSelected.id) {
            btn0.id -> btnClickValue += "0"
            btn1.id -> btnClickValue += "1"
            btn2.id -> btnClickValue += "2"
            btn3.id -> btnClickValue += "3"
            btn4.id -> btnClickValue += "4"
            btn5.id -> btnClickValue += "5"
            btn6.id -> btnClickValue += "6"
            btn7.id -> btnClickValue += "7"
            btn8.id -> btnClickValue += "8"
            btn9.id -> btnClickValue += "9"
            btnDot.id -> {
                btnClickValue += if (!btnClickValue.isEmpty() && !btnClickValue.contains(".")) "." else ""
            }
            else -> btnClickValue = "0"
        }
        edtResult.text = btnClickValue
        newNumber = btnClickValue
    }

    fun btnAC(view: View) {
        edtResult.text = if (this.operator.equals("")) "0" else ""
    }

    fun btnOP(view: View) {
        val btnSelected: Button = view as Button
        this.oldNumber = edtResult.text.toString()
        btnAC(view)

        when (btnSelected.id) {
            btnPlu.id -> this.operator = "+"
            btnMin.id -> this.operator = "-"
            btnMul.id -> this.operator = "*"
            btnDiv.id -> this.operator = "/"
            btnPer.id -> this.operator = "%"
            btnPluMin.id -> this.operator = "+/-"
        }

    }

    fun btnPluMin(view: View) {
        if (!edtResult.text.toString().equals("")
                && !edtResult.text.toString().equals("0")) {
            this.newNumber = "-" + edtResult.text
            edtResult.text = this.newNumber
        }
    }

    fun btnEqual(view: View) {
        var result: String = "0"

        when (this.operator) {
            "+" -> result = this.calculatorService.addition(this.oldNumber, this.newNumber)
            "-" -> result = this.calculatorService.substraction(this.oldNumber, this.newNumber)
            "*" -> result = this.calculatorService.multiplication(this.oldNumber, this.newNumber)
            "/" -> result = this.calculatorService.division(this.oldNumber, this.newNumber)
            "%" -> result = this.calculatorService.percentage(this.oldNumber)
        }

        edtResult.text = result
        this.oldNumber = "0"
        this.newNumber = "0"
        this.operator = ""
    }

}
