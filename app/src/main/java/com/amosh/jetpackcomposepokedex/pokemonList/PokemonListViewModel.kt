package com.amosh.jetpackcomposepokedex.pokemonList

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.palette.graphics.Palette
import com.amosh.jetpackcomposepokedex.models.PokeDexListEntry
import com.amosh.jetpackcomposepokedex.repository.PokemonRepository
import com.amosh.jetpackcomposepokedex.util.Constants
import com.amosh.jetpackcomposepokedex.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val repository: PokemonRepository,
) : ViewModel() {

    private var currentPage = 0

    var pokemonList = mutableStateOf<List<PokeDexListEntry>>(listOf())
    var loadError = mutableStateOf("")
    var isLoading = mutableStateOf(false)
    var endReached = mutableStateOf(false)

    private var cachedPokemonList = listOf<PokeDexListEntry>()
    private var isSearchingStarting = true
    var isSearching = mutableStateOf(false)

    init {
        loadPokemonPaginated()
    }

    fun searchPokemonList(query: String) {
        val listToSearch = when {
            isSearchingStarting -> pokemonList.value
            else -> cachedPokemonList
        }

        viewModelScope.launch(Dispatchers.Default) {
            if (query.isEmpty()) {
                pokemonList.value = cachedPokemonList
                isSearching.value = false
                isSearchingStarting = true
                return@launch
            } else {
                val results = listToSearch.filter { it.pokemonName.contains(query.trim(), true) || it.number.toString() == query.trim() }
                if (isSearchingStarting) {
                    cachedPokemonList = pokemonList.value
                    isSearchingStarting = false
                }
                pokemonList.value = results
                isSearching.value = true
            }
        }
    }

    fun loadPokemonPaginated() {
        viewModelScope.launch {
            isLoading.value = true
            val result = repository.getPokemonList(
                limit = Constants.PAGE_SIZE,
                offset = currentPage * Constants.PAGE_SIZE
            )

            when (result) {
                is Resource.Error -> {
                    loadError.value = result.message!!
                    isLoading.value = false
                }
                is Resource.Success -> {
                    endReached.value = currentPage * Constants.PAGE_SIZE >= result.data!!.count
                    val pokeDexListEntry = result.data.results.mapIndexed { index, entry ->
                        val number = if (entry.url.endsWith("/")) {
                            entry.url.dropLast(1).takeLastWhile { it.isDigit() }
                        } else {
                            entry.url.takeLastWhile { it.isDigit() }
                        }

                        val url = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${number}.png"
                        PokeDexListEntry(
                            pokemonName = entry.name.capitalize(Locale.ROOT),
                            imageUrl = url,
                            number = number.toInt()
                        )
                    }
                    currentPage++
                    loadError.value = ""
                    isLoading.value = false

                    pokemonList.value += pokeDexListEntry
                }
            }
        }
    }

    fun calcDominantColor(drawable: Drawable, onFinish: (Color) -> Unit) {
        val bmp = (drawable as BitmapDrawable).bitmap.copy(
            Bitmap.Config.ARGB_8888, true
        )
        Palette.from(bmp).generate { palette ->
            palette?.dominantSwatch?.rgb?.let { colorValue ->
                onFinish(Color(colorValue))
            }
        }
    }
}