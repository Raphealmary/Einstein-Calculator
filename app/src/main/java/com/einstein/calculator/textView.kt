package com.einstein.calculator

import android.icu.text.DecimalFormat

fun textView(operator: String, num2: String, num1: String): String {
    return if (operator == "*") {
        return "$num2 × $num1"
//        return DecimalFormat("#,##0.####")
//            .format(num2.toDouble()).toString() + "g" + DecimalFormat("#,##0.####")
//            .format(num1.toDouble()).toString()
    } else {
        return "$num2 $operator $num1"
    }
}