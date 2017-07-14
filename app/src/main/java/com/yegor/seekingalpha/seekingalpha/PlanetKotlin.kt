package com.yegor.seekingalpha.seekingalpha

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * model representing planet
 */
class PlanetKotlin : Serializable {

    val name = "No Name"

    @SerializedName("image_url")
    lateinit var URL: String

    val description = "No Description"
}
