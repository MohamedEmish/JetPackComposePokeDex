package com.amosh.jetpackcomposepokedex.data.remote.responses

import com.google.gson.annotations.SerializedName

data class Ability(
    val ability: DefaultDataObject,
    @SerializedName("is_hidden")
    val isHidden: Boolean,
    val slot: Int
)