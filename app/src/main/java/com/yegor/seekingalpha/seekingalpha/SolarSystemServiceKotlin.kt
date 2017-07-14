package com.yegor.seekingalpha.seekingalpha

import retrofit2.http.Url
import retrofit2.Call;
import retrofit2.http.GET

/**
 * Server API
 */
interface SolarSystemServiceKotlin {

    @GET
    fun loadPlanetsInfo(@Url pageNum: String): Call<PlanetsResponseKotlin>
}
