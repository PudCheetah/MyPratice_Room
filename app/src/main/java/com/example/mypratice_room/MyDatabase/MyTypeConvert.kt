package com.example.mypratice_room.MyDatabase

import androidx.room.TypeConverter
import com.google.gson.Gson

class MyTypeConvert {
    companion object{
        private val gson = Gson()
    }

    class ConvertForField{
        @TypeConverter
        fun getFieldFromString(value: String): List<Field>?{
            return gson.fromJson(value, Array<Field>::class.java).toList()
        }
        @TypeConverter
        fun getFieldToJson(value: List<Field>): String{
            return gson.toJson(value)
        }
    }
    class ConvertForTsunami{
        @TypeConverter
        fun getTsunamiFromString(value: String): List<Tsunami>?{
            return gson.fromJson(value, Array<Tsunami>::class.java).toList()
        }
        @TypeConverter
        fun getTsunamiToJson(value: List<Tsunami>): String{
            return gson.toJson(value)
        }
    }
    class ConvertForWarningArea{
        @TypeConverter
        fun getWarningAreaFromString(value: String): List<WarningArea>?{
            return gson.fromJson(value, Array<WarningArea>::class.java).toList()
        }
        @TypeConverter
        fun getWarningAreaToJson(value: List<WarningArea>): String{
            return gson.toJson(value)
        }
    }
    class ConvertForTsuStation{
        @TypeConverter
        fun getTsuStationFromString(value: String): List<TsuStation>?{
            return gson.fromJson(value, Array<TsuStation>::class.java).toList()
        }
        @TypeConverter
        fun getTsuStationToJson(value: List<TsuStation>): String{
            return gson.toJson(value)
        }
    }

}