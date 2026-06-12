package com.adbdev.solidhealth.ui.screen.medication

import androidx.compose.runtime.Composable

/**
 * Created by António Bastião on 12.06.2026
 * Refer to <a href="https://github.com/CurtesMalteser">CurtesMalteser GitHub</a>
 * or <a href="https://adb-dev.com">abd dev</a>
 */
context(args: LogMedicationArgs)
@Composable
fun LogMedicationPresenter(): LogMedicationState {
    return LogMedicationState(
        medicationName = "",
        selectedMedicationId = null,
        takenAt = args.clock.now(),
        showAddMedicationDialog = false
    )
}