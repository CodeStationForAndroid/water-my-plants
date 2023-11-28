package com.abaferastech.watermyplants.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface PlantDao {

    @Query("SELECT * FROM plant")
    fun getPlants(): Flow<List<Plant>>

    @Query("SELECT id, name, color, isWatered FROM plant WHERE id = :id")
    fun getPlantById(id: Int): Plant?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPlant(plant: Plant)

    @Delete
    fun deletePlant(plant: Plant)
}