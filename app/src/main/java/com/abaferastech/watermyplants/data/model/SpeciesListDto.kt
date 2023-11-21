package com.abaferastech.watermyplants.data.model

import com.google.gson.annotations.SerializedName

data class SpeciesListDto(
    val current_page: Int,
    @SerializedName("data")
    val speciesList: List<SpecieDto>,
    val from: Int,
    val last_page: Int,
    val per_page: Int,
    val to: Int,
    val total: Int
)

