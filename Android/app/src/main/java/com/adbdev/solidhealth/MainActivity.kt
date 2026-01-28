package com.adbdev.solidhealth

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.adbdev.solidhealth.data.db.Medication
import com.adbdev.solidhealth.data.db.MedicationDaoProvider
import com.adbdev.solidhealth.ui.theme.SolidHealthTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val medicationDaoProvider = applicationContext as MedicationDaoProvider
        lifecycleScope.launch {
            medicationDaoProvider.medicationDao.insertMedication(Medication(
                name = "placebo",
                isActive = true,
                dosage = "100 mg",
                form = "tablets",
                notes = "for breakfast"
            ))
        }
        enableEdgeToEdge()
        setContent {
            SolidHealthTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
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