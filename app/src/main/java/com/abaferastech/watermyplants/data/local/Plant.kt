package com.abaferastech.watermyplants.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.abaferastech.watermyplants.ui.theme.BabyBlue
import com.abaferastech.watermyplants.ui.theme.LightGreen
import com.abaferastech.watermyplants.ui.theme.RedOrange
import com.abaferastech.watermyplants.ui.theme.RedPink
import com.abaferastech.watermyplants.ui.theme.Violet

@Entity
data class Plant(
    val name: String,
    val color: Int,
    var isWatered: Boolean,
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    //    val image: Image,
//    val dateToWater: LocalDate,
//    val scienticName: String,
//    val watering: String,
//    val wateringFrequency: String,
//    val sunlightIntensity: String,
//    val description: String,
//    val careGuide: String,
//    val otherImage: String

){
    companion object {
        val itemColors = listOf(RedOrange, LightGreen, Violet, BabyBlue, RedPink)
    }
}

class InvalidPlantException(message: String): Exception(message)
