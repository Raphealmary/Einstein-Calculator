package com.einstein.calculator

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.window.DialogProperties

@Composable
fun Alert(showAlert: Boolean = false, onDismiss: () -> Unit) {
    if (showAlert) {
        AlertDialog(
            title = { Text("Einstein Calculator") },
            text = {
                Column() {
                    Text("Mandate Tech @2025")
                    Text("Copyright Raphealmary")
                }

            },
            onDismissRequest = onDismiss,
            properties = DialogProperties(),
            dismissButton = {
                Button(onClick = onDismiss) { Text("Close") }
            },
            confirmButton = {
                // Button(onClick = { alertShow = false }) { Text("Ok") }
            }
        )

    }

}


