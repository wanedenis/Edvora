package com.deniswane.edvora.model.main

import com.google.gson.annotations.SerializedName

data class Ride (@SerializedName("id") val id: Int,
                 @SerializedName("origin_station_code") val originStationCode: Int,
                 @SerializedName("station_path") val stationPath: List<Int>,
                 @SerializedName("destination_station_code") val destinationStationCode: Int,
                 @SerializedName("date") val date: String,
                 @SerializedName("map_url") val mapUrl: String,
                 @SerializedName("state") val state: String,
                 @SerializedName("city") val city: String)