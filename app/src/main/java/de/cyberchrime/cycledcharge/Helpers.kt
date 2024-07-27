package de.cyberchrime.cycledcharge

import android.content.Context
import android.os.BatteryManager
import kotlin.math.abs

fun getChargingCurrent(context: Context) : Int
{
    val batteryManager = context.getSystemService(Context.BATTERY_SERVICE) as BatteryManager

    val chargingCurrent = batteryManager.getIntProperty(BatteryManager.BATTERY_PROPERTY_CURRENT_NOW)

    var chargingCurrentInmA: Int = -chargingCurrent / 1000

    return chargingCurrentInmA
}
