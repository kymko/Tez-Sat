package com.example.tez_sat.model

data class RickiModel(
    val info: Info,
    val results: List<Result>
) {
    data class Info(
        val count: Int, // 671
        val next: String, // https://rickandmortyapi.com/api/character?page=2
        val pages: Int, // 34
        val prev: Any // null
    )

    data class Result(
        val created: String, // 2017-11-04T18:48:46.250Z
        val episode: List<String>,
        val gender: String, // Male
        val id: Int, // 1
        val image: String, // https://rickandmortyapi.com/api/character/avatar/1.jpeg
        val location: Location,
        val name: String, // Rick Sanchez
        val origin: Origin,
        val species: String, // Human
        val status: String, // Alive
        val type: String,
        val url: String // https://rickandmortyapi.com/api/character/1
    ) {
        data class Location(
            val name: String, // Earth (Replacement Dimension)
            val url: String // https://rickandmortyapi.com/api/location/20
        )

        data class Origin(
            val name: String, // Earth (C-137)
            val url: String // https://rickandmortyapi.com/api/location/1
        )
    }
}