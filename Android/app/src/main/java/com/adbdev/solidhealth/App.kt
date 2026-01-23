package com.adbdev.solidhealth

import android.app.Application
import androidx.room.Room
import com.adbdev.solidhealth.data.db.AppDB
import com.adbdev.solidhealth.data.db.MedicationDao
import com.adbdev.solidhealth.data.db.MedicationDaoProvider

/**
 * Created by António Bastião on 23.01.2026
 * Refer to <a href="https://github.com/CurtesMalteser">CurtesMalteser GitHub</a>
 * or <a href="https://adb-dev.com">abd dev</a>
 */
class App: Application(), MedicationDaoProvider {

    private val db : AppDB by lazy {
        Room.databaseBuilder(
            applicationContext,
            AppDB::class.java, "database-medication"
        ).build()
    }

    override val medicationDao: MedicationDao get() = db.medicationDao()
}