package com.abaferastech.watermyplants.watermyplantstesting.data.local

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.abaferastech.watermyplants.data.local.PlantDao
import com.abaferastech.watermyplants.data.local.PlantDatabase
import com.abaferastech.watermyplants.data.local.Plant
import junit.framework.TestCase.assertEquals
import org.junit.Assert.*
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

//@RunWith(AndroidJUnit4::class)
//@SmallTest
//class PlantDaoTest {
//
//    private lateinit var database: PlantDatabase
//    private lateinit var dao: PlantDao
//
//    @Before
//    fun setUp() {
//        database = Room.inMemoryDatabaseBuilder(
//            ApplicationProvider.getApplicationContext(),
//            PlantDatabase::class.java
//        ).allowMainThreadQueries().build()
//        dao = database.plantDao
//    }
//
//    @After
//    fun tearDown(){
//        database.close()
//    }
//
//
//    @Test
//    fun insertPlantItem() = runBlocking{
//        val plantItem = Plant(1, "named", 23, false)
//        dao.insertPlant(plantItem)
//
//        val testItem = dao.getPlantById(1)
//       // assertThat(testItem).isEqualTo(plantItem)
//        assertEquals(plantItem,testItem)
//    }
//
//    @Test
//    fun deletePlantItem() = runBlocking {
//        val plantItem = Plant(1, "named", 23, false)
//        dao.insertPlant(plantItem)
//        dao.deletePlant(plantItem)
//
//        val allPlantItems = dao.getPlants()
//        assertNotNull(allPlantItems)
//
//    }
//
//}