package com.adbdev.solidhealth.ui.screen.medication

import kotlin.time.Clock
import kotlin.time.Instant

/**
 * Created by António Bastião on 12.06.2026
 * Refer to <a href="https://github.com/CurtesMalteser">CurtesMalteser GitHub</a>
 * or <a href="https://adb-dev.com">abd dev</a>
 */
data class LogMedicationState(
    val selectedMedicationId: String? = null,
    val medicationName: String = "",
    val takenAt: Instant = Clock.System.now(),
    val showAddMedicationDialog: Boolean = false
)
