package com.abaferastech.watermyplants.data.remote

data class SpeciesListParam(
    val page: Int? = 1,   //The number page you want to see.
    val q: String? = null,      //A string/query consisting of keywords that are used to search for names of species
    val order: Order? = null,  //Alphabetical order species common name
    val edible: Int? = null,
    val poisonous: Int? = null,
    val cycle: Cycle? = null,
    val watering: Watering? = null,
    val sunlight: Sunlight? = null,
    val indoor: Int? = null,
    val hardiness: Int? = null
)

sealed class Order private constructor(val value: String? = null) {
    data object Ascending : Order("asc")
    data object Descending : Order("desc")
}

sealed class Cycle private constructor(val value: String? = null) {

    data object Perennial : Cycle("perennial")

    data object Annual : Cycle("annual")

    data object Biennial : Cycle("biennial")

    data object Biannual : Cycle("biannual")
}

sealed class Watering(val value: String) {

    class Frequent : Watering("frequent")

    class Average : Watering("average")

    class Minimum : Watering("minimum")

    class None : Watering("none")
}

sealed class Sunlight(val value: String) {

    class FullShade : Sunlight("full_shade")

    class PartShade : Sunlight("part_shade")

    class SunPartShade : Sunlight("sun-part_shade")

    class FullSun : Sunlight("full_sun")
}


