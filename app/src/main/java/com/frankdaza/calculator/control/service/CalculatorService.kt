package com.frankdaza.calculator.control.service

import java.math.BigDecimal

/**
 * @author Frank Edward Daza G.
 * @version Feb 03, 2018
 */
class CalculatorService {

    fun addition(number1: String, number2: String) : String {
        return BigDecimal(number1).add(BigDecimal(number2)).toString()
    }

    fun substraction(number1: String, number2: String) : String {
        return BigDecimal(number1).minus(BigDecimal(number2)).toString()
    }

    fun multiplication(number1: String, number2: String) : String {
        return BigDecimal(number1).multiply(BigDecimal(number2)).toString()
    }

    fun division(number1: String, number2: String) : String {
        return BigDecimal(number1).divide(BigDecimal(number2)).toString()
    }

    fun percentage(number1: String) : String {
        return BigDecimal(number1).divide(BigDecimal("10")).toString()
    }

}
