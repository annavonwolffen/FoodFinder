package com.annevonwolffen.foodfinder.ui.recipes

import androidx.compose.runtime.Composable
import com.annevonwolffen.foodfinder.ui.recipes.SearchRecipesScreen
import com.annevonwolffen.foodfinder.ui.recipes.FavoritesRecipesScreen

enum class RecipesScreens(
    val searchContentScreen: @Composable () -> Unit
) {
    RecipesSearch({ SearchRecipesScreen() }),
    Favorites({ FavoritesRecipesScreen() })
}