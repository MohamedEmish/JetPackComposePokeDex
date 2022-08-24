package com.amosh.jetpackcomposepokedex.util

import androidx.compose.ui.graphics.Color
import com.amosh.jetpackcomposepokedex.data.remote.responses.Stat
import com.amosh.jetpackcomposepokedex.data.remote.responses.Type
import com.amosh.jetpackcomposepokedex.ui.theme.AtkColor
import com.amosh.jetpackcomposepokedex.ui.theme.DefColor
import com.amosh.jetpackcomposepokedex.ui.theme.HPColor
import com.amosh.jetpackcomposepokedex.ui.theme.SpAtkColor
import com.amosh.jetpackcomposepokedex.ui.theme.SpDefColor
import com.amosh.jetpackcomposepokedex.ui.theme.SpdColor
import com.amosh.jetpackcomposepokedex.ui.theme.TypeBug
import com.amosh.jetpackcomposepokedex.ui.theme.TypeDark
import com.amosh.jetpackcomposepokedex.ui.theme.TypeDragon
import com.amosh.jetpackcomposepokedex.ui.theme.TypeElectric
import com.amosh.jetpackcomposepokedex.ui.theme.TypeFairy
import com.amosh.jetpackcomposepokedex.ui.theme.TypeFighting
import com.amosh.jetpackcomposepokedex.ui.theme.TypeFire
import com.amosh.jetpackcomposepokedex.ui.theme.TypeFlying
import com.amosh.jetpackcomposepokedex.ui.theme.TypeGhost
import com.amosh.jetpackcomposepokedex.ui.theme.TypeGrass
import com.amosh.jetpackcomposepokedex.ui.theme.TypeGround
import com.amosh.jetpackcomposepokedex.ui.theme.TypeIce
import com.amosh.jetpackcomposepokedex.ui.theme.TypeNormal
import com.amosh.jetpackcomposepokedex.ui.theme.TypePoison
import com.amosh.jetpackcomposepokedex.ui.theme.TypePsychic
import com.amosh.jetpackcomposepokedex.ui.theme.TypeRock
import com.amosh.jetpackcomposepokedex.ui.theme.TypeSteel
import com.amosh.jetpackcomposepokedex.ui.theme.TypeWater
import java.util.*

fun parseTypeToColor(type: Type): Color {
    return when(type.type.name.lowercase(Locale.ROOT)) {
        "normal" -> TypeNormal
        "fire" -> TypeFire
        "water" -> TypeWater
        "electric" -> TypeElectric
        "grass" -> TypeGrass
        "ice" -> TypeIce
        "fighting" -> TypeFighting
        "poison" -> TypePoison
        "ground" -> TypeGround
        "flying" -> TypeFlying
        "psychic" -> TypePsychic
        "bug" -> TypeBug
        "rock" -> TypeRock
        "ghost" -> TypeGhost
        "dragon" -> TypeDragon
        "dark" -> TypeDark
        "steel" -> TypeSteel
        "fairy" -> TypeFairy
        else -> Color.Black
    }
}

fun parseStatToColor(stat: Stat): Color {
    return when(stat.stat.name.lowercase()) {
        "hp" -> HPColor
        "attack" -> AtkColor
        "defense" -> DefColor
        "special-attack" -> SpAtkColor
        "special-defense" -> SpDefColor
        "speed" -> SpdColor
        else -> Color.White
    }
}

fun parseStatToAbbr(stat: Stat): String {
    return when(stat.stat.name.lowercase()) {
        "hp" -> "HP"
        "attack" -> "Atk"
        "defense" -> "Def"
        "special-attack" -> "SpAtk"
        "special-defense" -> "SpDef"
        "speed" -> "Spd"
        else -> ""
    }
}