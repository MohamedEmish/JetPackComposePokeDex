package com.amosh.jetpackcomposepokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.amosh.jetpackcomposepokedex.pokemonList.PokemonListScreen
import com.amosh.jetpackcomposepokedex.ui.theme.DOMINANT_COLOR
import com.amosh.jetpackcomposepokedex.ui.theme.JetPackComposePokeDexTheme
import com.amosh.jetpackcomposepokedex.ui.theme.LightBlue
import com.amosh.jetpackcomposepokedex.ui.theme.Navigation
import com.amosh.jetpackcomposepokedex.ui.theme.POKEMON_NAME
import com.amosh.jetpackcomposepokedex.ui.theme.spacing
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
                        Navigation.PokemonListScreen().name
                    ) {
                        PokemonListScreen(navController = navController)
                    }

                    composable(
                        "${Navigation.PokemonDetailsScreen().name}/{${DOMINANT_COLOR}}/{${POKEMON_NAME}}",
                        arguments = listOf(
                            navArgument(DOMINANT_COLOR) {
                                type = NavType.IntType
                            },
                            navArgument(POKEMON_NAME){
                                type = NavType.StringType
                            }
                        )
                    ) {
                        val dominantColor = remember {
                            val color = it.arguments?.getInt(DOMINANT_COLOR)
                            color?.let { Color(it) } ?: Color.White
                        }

                        val pokemonName = remember {
                            it.arguments?.getString(POKEMON_NAME)
                        }
                        // TODO :: CREATE DETAILS SCREEN UI
                    }
                }
            }
        }
    }
}
