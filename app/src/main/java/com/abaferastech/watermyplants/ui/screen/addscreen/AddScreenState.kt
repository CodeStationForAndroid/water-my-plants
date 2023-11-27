package com.abaferastech.watermyplants.ui.screen.addscreen

import android.media.Image
import androidx.compose.ui.graphics.toArgb
import com.abaferastech.watermyplants.data.local.Plant
import java.time.LocalDate

data class AddScreenState (
    var plantName: String = "",
    var dateToWater: LocalDate = LocalDate.now(),
    var image: Image? = null,
    val color: Int = Plant.itemColors.random().toArgb(),
)