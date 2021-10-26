package com.example.tez_sat.model

data class EpisodeModel(
    val info: Info,
    val results: List<Result>
) {
    data class Info(
        val count: Int, // 41
        val next: String, // https://rickandmortyapi.com/api/episode?page=2
        val pages: Int, // 3
        val prev: Any // null
    )

    data class Result(
        val air_date: String, // December 2, 2013
        val characters: List<String>,
        val created: String, // 2017-11-10T12:56:33.798Z
        val episode: String, // S01E01
        val id: Int, // 1
        val name: String, // Pilot
        val url: String // https://rickandmortyapi.com/api/episode/1
    )
}