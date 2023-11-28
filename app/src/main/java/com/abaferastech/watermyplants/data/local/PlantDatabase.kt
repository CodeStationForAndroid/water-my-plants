package com.abaferastech.watermyplants.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.abaferastech.watermyplants.data.local.Plant
import com.abaferastech.watermyplants.data.local.PlantDao


@Database(entities = [Plant::class], version = 1)
abstract class PlantDatabase: RoomDatabase() {
    abstract val plantDao: PlantDao
}