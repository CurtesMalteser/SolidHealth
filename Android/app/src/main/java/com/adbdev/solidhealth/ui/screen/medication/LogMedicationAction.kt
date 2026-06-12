package com.adbdev.solidhealth.ui.screen.medication

/**
 * Created by António Bastião on 12.06.2026
 * Refer to <a href="https://github.com/CurtesMalteser">CurtesMalteser GitHub</a>
 * or <a href="https://adb-dev.com">abd dev</a>
 */
sealed interface LogMedicationAction {
    data class MedicationSelected(val id: String) : LogMedicationAction
    data class MedicationNameChanged(val value: String) : LogMedicationAction
    data object SaveClicked : LogMedicationAction
    data object AddMedicationClicked : LogMedicationAction
    data object DialogDismissed : LogMedicationAction
}