# JetPackComposePokeDex

## Features

- Retrieve a list of Pokemons from the [poki api](https://pokeapi.co/) and show them in a grid list
- See more details about a selected on a new screen.

## Tech

- Kotlin
- Retrofit
- Jetpack compose
- MVVM
- Coroutines
- Hilt
- Coil

## Architecture

The architecture used in this project is a simple MVVM.
one repository holds the source where the data is provided (although in this project we won't be switching from local to remote in any feature). 
and a view model for each screen to retrieve the response.

## Preview


https://user-images.githubusercontent.com/40694943/186414170-a45f4966-99ee-4a15-86f9-3e413253e78d.mp4

