package com.amosh.jetpackcomposepokedex.data.remote.responses

import com.google.gson.annotations.SerializedName

data class GameIndex(
    @SerializedName("game_index")
    val gameIndex: Int,
    val version: DefaultDataObject
)