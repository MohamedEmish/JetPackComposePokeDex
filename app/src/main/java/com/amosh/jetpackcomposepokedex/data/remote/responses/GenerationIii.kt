package com.amosh.jetpackcomposepokedex.data.remote.responses

import com.google.gson.annotations.SerializedName

data class GenerationIii(
    val emerald: Emerald,
    @SerializedName("firered-leafgreen")
    val fireRedLeafGreen: FireRedLeafGreen,
    @SerializedName("ruby-sapphire")
    val rubySapphire: RubySapphire
)