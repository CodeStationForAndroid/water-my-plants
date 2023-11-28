package com.abaferastech.watermyplants.data.remote

import android.content.Context
import androidx.test.platform.app.InstrumentationRegistry
import com.abaferastech.watermyplants.data.model.SpeciesListDto
import com.google.gson.Gson
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.InputStreamReader

@RunWith(JUnit4::class)
class PlantApiServiceTest {

    private lateinit var mockWebServer: MockWebServer
    private lateinit var api: PlantApiService
    private lateinit var context: Context

    @Before
    fun setUp() {
        mockWebServer = MockWebServer()
        api = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))//Pass any base url like this
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(PlantApiService::class.java)
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

    @Test
    fun shouldJsonEqualsDto(){
        val dto = SpeciesListDto(
            to = 30,
            per_page = 30,
            current_page = 1,
            from = 1,
            last_page = 405,
            total = 10104,
            speciesList = emptyList()
        )
        context = InstrumentationRegistry.getInstrumentation().context
        val stream = context.resources.openRawResource(com.abaferastech.watermyplants.test.R.raw.response)
        val reader = InputStreamReader(stream)
        val speciesListDto = Gson().fromJson(reader, SpeciesListDto::class.java).apply { speciesList = emptyList() }
        assertEquals(speciesListDto.total, dto.total)
    }

    @Test
    fun getSpeciesList() {
        runBlocking {

            val dto = SpeciesListDto(
                to = 30,
                per_page = 30,
                current_page = 1,
                from = 1,
                last_page = 405,
                total = 10104,
                speciesList = emptyList()
                )
            context = InstrumentationRegistry.getInstrumentation().context
            val stream = context.resources.openRawResource(com.abaferastech.watermyplants.test.R.raw.response)
            val reader = InputStreamReader(stream)
            val json = Gson().fromJson(reader, SpeciesListDto::class.java)
            val res = MockResponse().apply { setBody(json.toString()) }
            mockWebServer.enqueue(res)
            val data = api.getSpeciesList(1, null, null, null, null, null, null, null, null, null)
            mockWebServer.takeRequest()
            assertEquals(data.speciesList.isEmpty(), dto.speciesList.isEmpty())
        }
    }

    @Test
    fun getPlantDetails() {
    }
}