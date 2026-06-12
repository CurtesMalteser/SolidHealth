package com.adbdev.solidhealth.ui.screen.medication

import com.adbdev.solidhealth.data.db.MedicationDao
import kotlin.time.Clock

/**
 * Created by António Bastião on 12.06.2026
 * Refer to <a href="https://github.com/CurtesMalteser">CurtesMalteser GitHub</a>
 * or <a href="https://adb-dev.com">abd dev</a>
 */
data class LogMedicationArgs(
    val medicationDao: MedicationDao,
    val clock: Clock,
)