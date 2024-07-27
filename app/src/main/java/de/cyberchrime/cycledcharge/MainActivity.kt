package de.cyberchrime.cycledcharge

import android.content.Context
import android.os.BatteryManager
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
import de.cyberchrime.cycledcharge.ui.theme.CycledChargeTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.abs


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        lifecycleScope.launch {
            while (true) {
                val chargingCurrentInmA: Int = getChargingCurrent(this@MainActivity)
                val speed: Float = getGpsSpeed(this@MainActivity)

                setContent {
                    CycledChargeTheme {
                        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                            MeasurementPrint(
                                currentInmA = "$chargingCurrentInmA",
                                speed = "$speed",
                                modifier = Modifier.padding(innerPadding)
                            )
                        }
                    }
                }

                delay(1000)
            }
        }
    }
}

@Composable
fun MeasurementPrint(currentInmA: String, speed: String, modifier: Modifier = Modifier) {
    Text(
        text = "Current: $currentInmA mA\nSpeed: $speed m/s",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CycledChargeTheme {
        MeasurementPrint("0", "0")
    }
}