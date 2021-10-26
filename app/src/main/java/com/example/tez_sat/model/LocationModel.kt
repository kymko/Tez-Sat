package com.example.tez_sat.model

data class LocationModel(
    val info: Info,
    val results: List<Result>
) {
    data class Info(
        val count: Int, // 108
        val next: String, // https://rickandmortyapi.com/api/location?page=2
        val pages: Int, // 6
        val prev: Any // null
    )

    data class Result(
        val created: String, // 2017-11-10T12:42:04.162Z
        val dimension: String, // Dimension C-137
        val id: Int, // 1
        val name: String, // Earth (C-137)
        val residents: List<String>,
        val type: String, // Planet
        val url: String // https://rickandmortyapi.com/api/location/1
    )
}