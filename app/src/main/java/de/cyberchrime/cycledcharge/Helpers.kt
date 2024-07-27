package de.cyberchrime.cycledcharge

import android.content.Context
import android.os.BatteryManager
import android.location.LocationManager

fun getChargingCurrent(context: Context) : Int
{
    val batteryManager = context.getSystemService(Context.BATTERY_SERVICE) as BatteryManager

    val chargingCurrent = batteryManager.getIntProperty(BatteryManager.BATTERY_PROPERTY_CURRENT_NOW)

    var chargingCurrentInmA: Int = -chargingCurrent / 1000

    return chargingCurrentInmA
}

fun getGpsSpeed(context: Context) : Float {
    val locationmanager: LocationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
    val location = locationmanager.getLastKnownLocation(LocationManager.GPS_PROVIDER)

    if (location != null)
        return location.getSpeed()

    return 0.0 as Float
}