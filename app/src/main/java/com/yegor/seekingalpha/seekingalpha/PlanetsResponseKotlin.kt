package com.yegor.seekingalpha.seekingalpha

import com.google.gson.annotations.SerializedName

/**
 * model representing server response
 */
class PlanetsResponseKotlin {

    val page = 0

    @SerializedName("items")
    var planets: List<PlanetKotlin>? = null
}