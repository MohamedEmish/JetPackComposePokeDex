package com.amosh.jetpackcomposepokedex.data.remote.responses

import com.google.gson.annotations.SerializedName

data class GenerationIv(
    @SerializedName("diamond-pearl")
    val diamondPearl: DiamondPearl,
    @SerializedName("heartgold-soulsilver")
    val heartGoldSoulSilver: HeartGoldSoulSilver,
    val platinum: Platinum
)