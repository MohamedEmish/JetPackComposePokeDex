package com.amosh.jetpackcomposepokedex.pokemonDetails

import androidx.compose.ui.text.toLowerCase
import androidx.lifecycle.ViewModel
import com.amosh.jetpackcomposepokedex.data.remote.responses.Pokemon
import com.amosh.jetpackcomposepokedex.repository.PokemonRepository
import com.amosh.jetpackcomposepokedex.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.*
import javax.inject.Inject

@HiltViewModel
class PokemonDetailsViewModel @Inject constructor(
    private val repository: PokemonRepository,
) : ViewModel() {

    suspend fun getPokemonInfo(name: String): Resource<Pokemon> {
        return repository.getPokemonInfo(name.lowercase(Locale.ROOT))
    }
}