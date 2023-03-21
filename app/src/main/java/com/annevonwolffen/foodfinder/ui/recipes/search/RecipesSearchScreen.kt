package com.annevonwolffen.foodfinder.ui.recipes.search

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun RecipesSearchScreen(
    viewModel: RecipesSearchViewModel = viewModel()
) {
    val searchState by viewModel.searchState.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            SearchTopBar(
                modifier = Modifier.fillMaxWidth(),
                query = searchState.query,
                onQueryChanged = { query -> viewModel.onQueryChanged(query) }

            )
        }
    ) { padding ->
        FoundContent(Modifier.padding(padding))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchTopBar(
    modifier: Modifier = Modifier,
    query: String = "",
    onQueryChanged: (String) -> Unit,
    onSearch: (String) -> Unit = {},
    onActiveChange: (Boolean) -> Unit = {},
) {
    SearchBar(
        modifier = modifier,
        query = query,
        onQueryChange = onQueryChanged,
        onSearch = onSearch,
        active = false,
        onActiveChange = onActiveChange,
        trailingIcon = {
            Icon(Icons.Default.Search, contentDescription = null)
        }
    ) {}
}

@Composable
fun FoundContent(
    modifier: Modifier = Modifier
) {
}