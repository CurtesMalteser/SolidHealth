package com.adbdev.solidhealth

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.adbdev.solidhealth.data.db.MedicationDaoProvider
import com.adbdev.solidhealth.ui.screen.medication.LogMedicationArgs
import com.adbdev.solidhealth.ui.screen.medication.LogMedicationPresenter
import com.adbdev.solidhealth.ui.screen.medication.LogMedicationScreen
import com.adbdev.solidhealth.ui.theme.SolidHealthTheme
import kotlin.time.Clock

class MainActivity : ComponentActivity() {

    private val medicationDaoProvider: MedicationDaoProvider
        get() = application as MedicationDaoProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val args = LogMedicationArgs(
            medicationDao = medicationDaoProvider.medicationDao,
            clock = Clock.System
        )
        enableEdgeToEdge()
        setContent {

            with(args) {
                val state = LogMedicationPresenter()
                SolidHealthTheme(dynamicColor = false) {
                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        topBar = {AppBar(R.string.app_name)},
                    ) { innerPadding ->
                        LogMedicationScreen(
                            modifier = Modifier.padding(innerPadding),
                            state = state,
                            onAction = {

                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SolidHealthTheme {
        Greeting("Android")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AppBar(@StringRes id: Int, modifier: Modifier = Modifier) {
    TopAppBar(
        modifier = modifier,
        title = { Text(text = stringResource(id = id)) },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary
        )
    )
}