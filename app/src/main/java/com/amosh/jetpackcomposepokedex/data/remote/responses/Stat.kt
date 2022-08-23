package com.amosh.jetpackcomposepokedex.data.remote.responses

import com.google.gson.annotations.SerializedName

data class Stat(
    @SerializedName("base_stat")
    val baseStat: Int,
    val effort: Int,
    val stat: DefaultDataObject
)