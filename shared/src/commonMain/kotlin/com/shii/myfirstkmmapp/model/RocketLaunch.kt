package com.shii.myfirstkmmapp.model

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class RocketLaunch(
    @SerialName("flight_number")
    val flightNumber: Int,
    @SerialName("name")
    val missionName: String,
    @SerialName("date_utc")
    val launchDateUTC: String,
    @SerialName("success")
    val launchSuccess: Boolean?
)
