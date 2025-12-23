package com.einstein.calculator

import android.icu.text.DecimalFormat
import android.icu.text.NumberFormat
import java.util.Locale

fun textView(operator: String, num2: String, num1: String): String {
     val formatter = DecimalFormat("#,##0.##");
    //val formatter = NumberFormat.getInstance(Locale.US)

    var numberOne: String = ""
    var numberTwo: String = ""

    if (num1.endsWith('.') || num1.endsWith('.')) {
        return "$num2 $operator $num1"
    };

    if (num1.isNotEmpty()) {
        numberOne = formatter.format(num1.toDouble())
    }
    if (num2.isNotEmpty()) {
        numberTwo = formatter.format(num2.toDouble())
    }

    return "$numberTwo $operator $numberOne";
//return "$num2 $operator $num1";
}