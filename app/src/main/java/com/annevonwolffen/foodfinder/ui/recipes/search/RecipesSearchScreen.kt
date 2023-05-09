package com.annevonwolffen.foodfinder.ui.recipes.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun RecipesSearchScreen(
    viewModel: RecipesSearchViewModel
) {
    val searchState by viewModel.searchState.collectAsStateWithLifecycle()

    Scaffold { padding ->
        Column {
            SearchTopBar(
                modifier = Modifier.fillMaxWidth(),
                query = searchState.query,
                onQueryChanged = { query -> viewModel.onEvent(UIEvent.QueryChanged(query)) },
                onSearch = { query -> viewModel.onEvent(UIEvent.Search(query)) },
                enabled = !searchState.showProgressBar
            )
            FoundContent(
                modifier = Modifier.padding(padding),
                foundRecipes = searchState.foundContent
            )
        }

        if (searchState.showProgressBar) {
            LoadingScreen()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SearchTopBar(
    modifier: Modifier = Modifier,
    query: String = "",
    onQueryChanged: (String) -> Unit,
    onSearch: (String) -> Unit = {},
    onActiveChange: (Boolean) -> Unit = {},
    enabled: Boolean = true
) {
    SearchBar(
        modifier = modifier,
        query = query,
        onQueryChange = onQueryChanged,
        onSearch = onSearch,
        active = false,
        onActiveChange = onActiveChange,
        trailingIcon = {
            IconButton(onClick = { onSearch(query) }) {
                Icon(Icons.Default.Search, contentDescription = null)
            }
        },
        enabled = enabled
    ) {}
}

@Composable
private fun LoadingScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Gray.copy(alpha = 0.3f))
            .pointerInput(Unit) {},
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
private fun FoundContent(
    modifier: Modifier = Modifier,
    foundRecipes: List<String>
) {
    val listState = rememberLazyListState()
    LazyColumn(
        modifier = modifier,
        state = listState
    ) {
        items(foundRecipes) { recipe ->

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = recipe
            )
        }
    }
}