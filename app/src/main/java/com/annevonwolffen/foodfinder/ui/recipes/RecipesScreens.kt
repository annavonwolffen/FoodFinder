package com.annevonwolffen.foodfinder.ui.recipes

import androidx.compose.runtime.Composable
import com.annevonwolffen.foodfinder.ui.recipes.favorites.RecipesFavoritesScreen
import com.annevonwolffen.foodfinder.ui.recipes.search.RecipesSearchScreen

enum class RecipesScreens(
    val searchContentScreen: @Composable () -> Unit
) {
    RecipesSearch({ RecipesSearchScreen() }),
    Favorites({ RecipesFavoritesScreen() })
}