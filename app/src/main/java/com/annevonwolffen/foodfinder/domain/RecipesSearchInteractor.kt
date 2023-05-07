package com.annevonwolffen.foodfinder.domain

interface RecipesSearchInteractor {
    suspend fun searchRecipes(query: String): List<String>
}