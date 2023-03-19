package com.annevonwolffen.foodfinder.ui

interface Destination {
    val route: String
}

object MainDestination : Destination {
    override val route = "main"
}

enum class StartDestinations(
    override val route: String
) : Destination {

    Recipes(
        route = "recipes"
    ),
    Profile(
        route = "profile"
    )
}