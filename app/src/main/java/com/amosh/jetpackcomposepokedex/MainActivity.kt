package com.amosh.jetpackcomposepokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.amosh.jetpackcomposepokedex.pokemonDetails.PokemonDetailsScreen
import com.amosh.jetpackcomposepokedex.pokemonList.PokemonListScreen
import com.amosh.jetpackcomposepokedex.ui.theme.DOMINANT_COLOR
import com.amosh.jetpackcomposepokedex.ui.theme.JetPackComposePokeDexTheme
import com.amosh.jetpackcomposepokedex.ui.theme.Navigation
import com.amosh.jetpackcomposepokedex.ui.theme.POKEMON_NAME
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposePokeDexTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Navigation.PokemonListScreen().name
                ) {
                    composable(
                        route = Navigation.PokemonListScreen().name
                    ) {
                        PokemonListScreen(navController = navController)
                    }

                    composable(
                        route = "${Navigation.PokemonDetailsScreen().name}/{${DOMINANT_COLOR}}/{${POKEMON_NAME}}",
                        arguments = listOf(
                            navArgument(DOMINANT_COLOR) {
                                type = NavType.IntType
                            },
                            navArgument(POKEMON_NAME) {
                                type = NavType.StringType
                            }
                        )
                    ) {
                        val dominantColor = remember {
                            val color = it.arguments?.getInt(DOMINANT_COLOR)
                            color?.let { Color(it) } ?: Color.White
                        }

                        val pokemonName = remember {
                            it.arguments?.getString(POKEMON_NAME) ?: ""
                        }

                        PokemonDetailsScreen(
                            dominantColor = dominantColor,
                            pokemonName = pokemonName,
                            navController = navController
                        )
                    }
                }
            }
        }
    }
}
