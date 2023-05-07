package com.annevonwolffen.foodfinder.ui.recipes.search

import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
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
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch

@Composable
fun RecipesSearchScreen(
    viewModel: RecipesSearchViewModel
) {
    Log.d("RecipesSearchScreen", "viewModel: $viewModel")
    val searchState by viewModel.searchState.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            SearchTopBar(
                modifier = Modifier.fillMaxWidth(),
                query = searchState.query,
                onQueryChanged = { query -> viewModel.onEvent(UIEvent.QueryChanged(query)) },
                onSearch = { query -> viewModel.onEvent(UIEvent.Search(query)) }
            )
        }
    ) { padding ->
        FoundContent(
            modifier = Modifier.padding(padding),
            foundRecipes = searchState.foundContent
        )
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