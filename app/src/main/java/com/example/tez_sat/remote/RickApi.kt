package com.example.tez_sat.remote

import com.example.tez_sat.model.EpisodeModel
import com.example.tez_sat.model.LocationModel
import com.example.tez_sat.model.RickiModel
import com.example.tez_sat.model.SingleModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickApi {

    @GET("character")
    suspend fun getAllCharacters():Response<RickiModel>

    @GET("character/{id}")
        suspend fun getCharacterById(
        @Path("id") id:Int
    ):Response<SingleModel>

    @GET("location")
    suspend fun getAllLocations():Response<LocationModel>

     @GET("episode")
    suspend fun getAllEpisodes():Response<EpisodeModel>

    @GET("character")
    suspend fun getFilterCharacter(
        @Query("name") name:String,
        @Query("status") status:String,
        @Query("gender") gender:String
    ):Response<RickiModel>

}