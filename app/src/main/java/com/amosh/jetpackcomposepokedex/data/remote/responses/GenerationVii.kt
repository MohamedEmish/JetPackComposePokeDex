package com.amosh.jetpackcomposepokedex.data.remote.responses

import androidx.compose.material.icons.Icons
import com.google.gson.annotations.SerializedName

data class GenerationVii(
    val icons: Icons,
    @SerializedName("ultra-sun-ultra-moon")
    val ultraSunUltraMoon: UltraSunUltraMoon
)