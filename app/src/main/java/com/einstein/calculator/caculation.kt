package com.einstein.calculator

import java.text.DecimalFormat

fun Calculation(operator: String, num1: String, num2: String): String {
    if (operator == "+") {
        if (num1 == "") {
            return ""
        } else {
            return (DecimalFormat("#,##0.####").format(num2.toDouble() + num1.toDouble())).toString()

        }
    } else if (operator == "-") {
        if (num1 == "") {
            return ""
        } else {
            return (DecimalFormat("#,##0.####").format(num2.toDouble() - num1.toDouble())).toString()
        }
    } else if (operator == "*") {
        if (num1 == "") {
            return ""
        }
        return (DecimalFormat("#,##0.####").format(num2.toDouble() * num1.toDouble())).toString()
    } else if (operator == "÷") {
        if (num1 == "") {
            return ""
        }
        return (DecimalFormat("#,##0.####").format(num2.toDouble() / num1.toDouble())).toString()
    } else {
        return ""
    }

}


