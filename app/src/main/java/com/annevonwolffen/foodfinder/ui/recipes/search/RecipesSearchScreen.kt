package com.annevonwolffen.foodfinder.ui.recipes.search

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipesSearchScreen() {
    Scaffold(
        topBar = { SearchTopBar() }
    ) { padding ->
        FoundContent(Modifier.padding(padding))
    }
}

@Composable
fun SearchTopBar(
    modifier: Modifier = Modifier
) {
    SearchField()
}

@Composable
fun SearchField() {

}

@Composable
fun FoundContent(
    modifier: Modifier = Modifier
) {
}