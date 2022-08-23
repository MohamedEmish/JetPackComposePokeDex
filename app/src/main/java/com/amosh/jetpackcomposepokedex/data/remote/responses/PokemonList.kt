package com.amosh.jetpackcomposepokedex.data.remote.responses

data class PokemonList(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<DefaultDataObject>,
)