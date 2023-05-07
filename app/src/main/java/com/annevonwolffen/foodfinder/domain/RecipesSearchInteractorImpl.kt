package com.annevonwolffen.foodfinder.domain

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RecipesSearchInteractorImpl @Inject constructor() : RecipesSearchInteractor {
    override suspend fun searchRecipes(query: String): List<String> {
        return withContext(Dispatchers.IO) {
            delay(5000L)
            IntRange(1, 100).map { "Recipe $it" }
        }
    }
}