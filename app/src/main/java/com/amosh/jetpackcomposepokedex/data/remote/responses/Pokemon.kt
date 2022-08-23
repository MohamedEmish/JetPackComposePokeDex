package com.amosh.jetpackcomposepokedex.data.remote.responses

import com.google.gson.annotations.SerializedName
import java.text.Normalizer

data class Pokemon(
    val abilities: List<Ability>,
    @SerializedName("base_experience")
    val baseExperience: Int,
    val forms: List<Normalizer.Form>,
    @SerializedName("game_indices")
    val gameIndices: List<GameIndex>,
    val height: Int,
    @SerializedName("held_items")
    val heldItems: List<Any>,
    val id: Int,
    @SerializedName("is_default")
    val isDefault: Boolean,
    @SerializedName("location_area_encounters")
    val locationAreaEncounters: String,
    val moves: List<Move>,
    val name: String,
    val order: Int,
    @SerializedName("past_types")
    val pastTypes: List<Any>,
    val species: DefaultDataObject,
    val sprites: Sprites,
    val stats: List<Stat>,
    val types: List<Type>,
    val weight: Int,
)