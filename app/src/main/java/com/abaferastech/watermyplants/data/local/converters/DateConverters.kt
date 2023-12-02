package com.abaferastech.watermyplants.data.local.converters

import androidx.room.TypeConverter
import java.time.LocalDate
import java.time.ZoneId

class DateConverters {
    @TypeConverter
    fun fromTimestamp(value: Long?): LocalDate? {
        return value?.let { LocalDate.ofEpochDay(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: LocalDate?): Long? {
        val zoneId: ZoneId = ZoneId.systemDefault()
        return date?.atStartOfDay(zoneId)?.toEpochSecond()
    }
}