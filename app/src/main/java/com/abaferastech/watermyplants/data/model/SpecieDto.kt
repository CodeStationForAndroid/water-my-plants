package com.abaferastech.watermyplants.data.model

data class SpecieDto(
    val common_name: String,
    val cycle: String,
    val default_image: DefaultImageDto,
    val id: Int,
    val other_name: List<String>,
    val scientific_name: List<String>,
    val sunlight: List<String>,
    val watering: String
)

fun SpecieDto.toDomain(): Nothing = TODO()
