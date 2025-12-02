package com.einstein.calculator

fun textView(operator: String, num2: String, num1: String): String {
    return if (operator == "*") {
        return "$num2 × $num1"
    } else {
        return "$num2 $operator $num1"
    }
}