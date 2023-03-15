package com.annevonwolffen.foodfinder.ui

import androidx.compose.runtime.Composable

enum class SearchScreen(
    val searchContentScreen: @Composable () -> Unit
) {
    Recipes({ SearchRecipesScreen() }),
    Food({ SearchFoodScreen() })
}