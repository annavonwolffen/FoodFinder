package com.annevonwolffen.foodfinder.ui.recipes.search

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class RecipesSearchViewModel : ViewModel() {

    val searchState: StateFlow<SearchState>
        get() = _searchState
    private val _searchState = MutableStateFlow(SearchState())

    fun onQueryChanged(query: String) {
        _searchState.value = _searchState.value.copy(query = query)
    }
}

data class SearchState(
    val query: String = "",
    val showProgressBar: Boolean = false,
    val foundContent: List<String> = emptyList(),
    val showSearchError: Boolean = false
)