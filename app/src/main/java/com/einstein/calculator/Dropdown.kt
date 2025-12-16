package com.einstein.calculator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Dropdown(

) {
    var dropdownList = listOf("Setting", "Help", "About")

    var expanded by remember { mutableStateOf(false) }
    var showAlert by remember { mutableStateOf(false) }
    Alert(showAlert, onDismiss = { showAlert = false })
    DropdownMenu(
        expanded = expanded,
        onDismissRequest = { expanded = false }

    ) {
        Column(

            modifier = Modifier
                .width(200.dp)

                .clip(RoundedCornerShape(10.dp))
                .background(MaterialTheme.colorScheme.tertiary),

            ) {

            dropdownList.forEach {
                DropdownMenuItem(

                    onClick = {
                        expanded = false
                        if (it == "About") {
                            showAlert = true
                        }
                    },
                    text = {
                        Text(
                            text = it.toString(),
                            fontSize = 15.sp
                        )
                    },

                    )


            }
        }


    }
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = MaterialTheme.colorScheme.onPrimary
        ),
        shape = RoundedCornerShape(5.dp),
        onClick = { expanded = true }
    ) {
        Icon(Icons.Default.MoreVert, contentDescription = null)
    }


}

