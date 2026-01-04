package com.adbdev.solidhealth.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * Created by António Bastião on 04.01.2026
 * Refer to <a href="https://github.com/CurtesMalteser">CurtesMalteser GitHub</a>
 * or <a href="https://adb-dev.com">abd dev</a>
 */

@Database(entities = [Medication::class], version = 1)
abstract class AppDB : RoomDatabase() {
    abstract fun medicationDao(): MedicationDao
}