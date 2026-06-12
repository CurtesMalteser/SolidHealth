package com.adbdev.solidhealth.ui.screen.medication

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * Created by António Bastião on 12.06.2026
 * Refer to <a href="https://github.com/CurtesMalteser">CurtesMalteser GitHub</a>
 * or <a href="https://adb-dev.com">abd dev</a>
 */
@Composable
fun LogMedicationScreen(
    modifier: Modifier,
    state: LogMedicationState,
    onAction: (LogMedicationAction) -> Unit
) {
    Text(
        text = "Hello there!",
        modifier = modifier
    )
    Button(onClick = {
        onAction.invoke(LogMedicationAction.AddMedicationClicked)
    })  {
        Text(
            text = "Click Action!"
        )
    }
}