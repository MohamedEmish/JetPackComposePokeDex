package com.amosh.jetpackcomposepokedex.ui.theme

sealed class Navigation(
    val name: String = "",
) {
    class PokemonListScreen(name: String = "pokemon_list_screen") : Navigation(name)
    class PokemonDetailsScreen(name: String = "pokemon_details_screen") : Navigation(name)
}

const val DOMINANT_COLOR = "DOMINANT_COLOR"
const val POKEMON_NAME = "POKEMON_NAME"