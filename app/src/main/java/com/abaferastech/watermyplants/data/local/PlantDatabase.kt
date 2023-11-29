package com.abaferastech.watermyplants.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.abaferastech.watermyplants.data.local.converters.DateConverters
import com.abaferastech.watermyplants.data.local.converters.ImageConverters

@TypeConverters(ImageConverters::class, DateConverters::class)
@Database(entities = [Plant::class], version = 3)
abstract class PlantDatabase: RoomDatabase() {
    abstract val plantDao: PlantDao
}