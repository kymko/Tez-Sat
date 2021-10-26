package com.example.tez_sat.model

data class SingleModel(
    val created: String, // 2017-11-04T18:50:21.651Z
    val episode: List<Any>,
    val gender: String, // Male
    val id: Int, // 2
    val image: String, // https://rickandmortyapi.com/api/character/avatar/2.jpeg
    val location: Location,
    val name: String, // Morty Smith
    val origin: Origin,
    val species: String, // Human
    val status: String, // Alive
    val type: String,
    val url: String // https://rickandmortyapi.com/api/character/2
) {
    data class Location(
        val name: String, // Earth
        val url: String // https://rickandmortyapi.com/api/location/20
    )

    data class Origin(
        val name: String, // Earth
        val url: String // https://rickandmortyapi.com/api/location/1
    )
}