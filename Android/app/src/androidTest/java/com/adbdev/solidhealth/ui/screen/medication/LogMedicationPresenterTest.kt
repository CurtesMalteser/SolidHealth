package com.adbdev.solidhealth.ui.screen.medication

import androidx.compose.ui.test.junit4.v2.createComposeRule
import com.adbdev.solidhealth.data.db.Medication
import com.adbdev.solidhealth.data.db.MedicationDao
import kotlinx.coroutines.flow.Flow
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import kotlin.time.Clock
import kotlin.time.Instant

/**
 * Created by António Bastião on 19.06.2026
 * Refer to <a href="https://github.com/CurtesMalteser">CurtesMalteser GitHub</a>
 * or <a href="https://adb-dev.com">abd dev</a>
 */
class LogMedicationPresenterTest {
    @get:Rule val composeRule = createComposeRule()

    @Test
    fun presenter_uses_clock_from_args() {
        val fixedClock = fixedClock()

        val args = LogMedicationArgs(
            medicationDao = fakeMedicationDao(),
            clock = fixedClock()
        )

        composeRule.setContent {
            val state = with(args) {
                LogMedicationPresenter()
            }
            assertEquals(fixedClock.now(), state.takenAt)
        }

    }

    // Collapsed for brevity
    private fun fakeMedicationDao() = object : MedicationDao {
        override fun getAllMedications(): Flow<List<Medication>> {
            TODO("Not yet implemented")
        }

        override suspend fun insertMedication(medication: Medication) {
            TODO("Not yet implemented")
        }

        override suspend fun updateMedication(medication: Medication) {
            TODO("Not yet implemented")
        }

        override suspend fun deleteMedication(medication: Medication) {
            TODO("Not yet implemented")
        }
    }

    private fun fixedClock() = object : Clock {
        override fun now(): Instant = Instant.parse("2026-06-19T20:00:00Z")
    }
}