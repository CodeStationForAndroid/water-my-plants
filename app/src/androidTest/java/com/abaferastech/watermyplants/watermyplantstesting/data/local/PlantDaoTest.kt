package com.abaferastech.watermyplants.watermyplantstesting.data.local

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import com.abaferastech.watermyplants.data.local.Plant
import com.abaferastech.watermyplants.data.local.PlantDao
import com.abaferastech.watermyplants.data.local.PlantDatabase
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@MediumTest
class PlantDaoTest {

    private lateinit var database: PlantDatabase
    private lateinit var dao: PlantDao

    @Before
    fun setUp() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            PlantDatabase::class.java
        ).allowMainThreadQueries().build()
        dao = database.plantDao
    }

    @After
    fun tearDown(){
        database.close()
    }


    @Test
    fun insertPlantItem() = runBlocking{
        val plantItem = Plant(id = 1, name = "named", color =  23,  isWatered = false)
        dao.insertPlant(plantItem)

        val testItem = dao.getPlantById(1)
        assertEquals(plantItem,testItem)
    }

    @Test
    fun deletePlantItem() = runBlocking {
        val plantItem = Plant(id = 1, name = "named", color = 23, isWatered =  false)
        dao.insertPlant(plantItem)
        dao.deletePlant(plantItem)

        val allPlantItems = dao.getPlants()
        assertNotNull(allPlantItems)

    }

}