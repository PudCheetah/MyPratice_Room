package com.example.mypratice_room.MyDatabase

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName

@Entity
data class MyJsonClass(
    @PrimaryKey(autoGenerate = true)
    var MyJsonClassID: Int = 0,
    @SerializedName("success")
    val success: String,
    @Embedded
    @SerializedName("result")
    val result: Result,
    @Embedded
    @SerializedName("records")
    val records: Records
)

@Entity
@TypeConverters(MyTypeConvert.ConvertForField::class)
data class Result(
    @PrimaryKey(autoGenerate = true)
    var ResultID: Int = 0,
    @SerializedName("resource_id")
    val resourceId: String,
    @Embedded
    @SerializedName("fields")
    val fields: List<Field>
)

@Entity
@TypeConverters(MyTypeConvert.ConvertForTsunami::class)
data class Records(
    @PrimaryKey(autoGenerate = true)
    var RecordsID: Int = 0,
    @SerializedName("datasetDescription")
    val datasetDescription: String,
    @Embedded
    @SerializedName("Tsunami")
    val tsunami: List<Tsunami>
)

@Entity
data class Field(
    @PrimaryKey(autoGenerate = true)
    var FieldID: Int = 0,
    @SerializedName("id")
    val id: String,
    @SerializedName("type")
    val type: String
)

@Entity
data class Tsunami(
    @PrimaryKey(autoGenerate = true)
    var TsunamiID: Int = 0,
    @SerializedName("ReportColor")
    val reportColor: String,
    @SerializedName("ReportContent")
    val reportContent: String,
    @SerializedName("ReportNo")
    val reportNo: String,
    @SerializedName("ReportType")
    val reportType: String,
    @SerializedName("TsunamiNo")
    val tsunamiNo: Int,
    @SerializedName("Web")
    val web: String,
    @Embedded
    @SerializedName("EarthquakeInfo")
    val earthquakeInfo: EarthquakeInfo,
    @Embedded
    @SerializedName("TsunamiWave")
    val tsunamiWave: TsunamiWave
)

@Entity
data class EarthquakeInfo(
    @PrimaryKey(autoGenerate = true)
    var EarthquakeInfoID: Int = 0,
    @SerializedName("OriginTime")
    val originTime: String,
    @SerializedName("Source")
    val source: String,
    @SerializedName("FocalDepth")
    val focalDepth: Double,
    @Embedded
    @SerializedName("Epicenter")
    val epicenter: Epicenter,
    @Embedded
    @SerializedName("EarthquakeMagnitude")
    val earthquakeMagnitude: EarthquakeMagnitude
)

@Entity
@TypeConverters(MyTypeConvert.ConvertForWarningArea::class, MyTypeConvert.ConvertForTsuStation::class)
data class TsunamiWave(
    @PrimaryKey(autoGenerate = true)
    var TsunamiWaveID: Int = 0,
    @Embedded
    @SerializedName("WarningArea")
    val warningArea: List<WarningArea>,
    @Embedded
    @SerializedName("TsuStation")
    val tsuStation: List<TsuStation>
)

@Entity
data class Epicenter(
    @PrimaryKey(true)
    var EpicenterID: Int = 0,
    @SerializedName("Location")
    val location: String,
    @SerializedName("EpicenterLatitude")
    val epicenterLatitude: Double,
    @SerializedName("EpicenterLongitude")
    val epicenterLongitude: Double
)

@Entity
data class EarthquakeMagnitude(
    @PrimaryKey(autoGenerate = true)
    var EarthquakeMagnitudeID: Int = 0,
    @SerializedName("MagnitudeValue")
    val magnitudeValue: Double
)

@Entity
data class WarningArea(
    @PrimaryKey(autoGenerate = true)
    var WarningAreaID: Int = 0,
    @SerializedName("AreaColor")
    val areaColor: String,
    @SerializedName("AreaDesc")
    val areaDesc: String,
    @SerializedName("AreaName")
    val areaName: String,
    @SerializedName("ArrivalTime")
    val arrivalTime: String,
    @SerializedName("InfoStatus")
    val infoStatus: String,
    @SerializedName("WaveHeight")
    val waveHeight: String
)

@Entity
data class TsuStation(
    @PrimaryKey(autoGenerate = true)
    var TsuStationID: Int = 0,
    @SerializedName("ArrivalTime")
    val arrivalTime: String,
    @SerializedName("InfoStatus")
    val infoStatus: String,
    @SerializedName("StationID")
    val stationID: String,
    @SerializedName("StationName")
    val stationName: String,
    @SerializedName("StationLatitude")
    val stationLatitude: Double,
    @SerializedName("StationLongitude")
    val stationLongitude: Double,
    @SerializedName("WaveHeight")
    val waveHeight: String
)