package com.annevonwolffen.foodfinder.ui.recipes.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.annevonwolffen.foodfinder.domain.RecipesSearchInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipesSearchViewModel @Inject constructor(
    private val recipesSearchInteractor: RecipesSearchInteractor
) : ViewModel() {

    val searchState: StateFlow<SearchState>
        get() = _searchState
    private val _searchState = MutableStateFlow(SearchState())

    fun onEvent(event: UIEvent) {
        when (event) {
            is UIEvent.QueryChanged -> {
                _searchState.value = _searchState.value.copy(query = event.query)
            }
            is UIEvent.Search -> {
                performSearch(event.query)
            }
        }
    }

    private fun performSearch(query: String) {
        viewModelScope.launch {
            _searchState.value = _searchState.value.copy(
                showProgressBar = true,
                showSearchError = false
            )
            val recipes = recipesSearchInteractor.searchRecipes(query)
            _searchState.value = _searchState.value.copy(
                showProgressBar = false,
                foundContent = recipes,
                showSearchError = false
            )
        }
    }
}

data class SearchState(
    val query: String = "",
    val showProgressBar: Boolean = false,
    val foundContent: List<String> = emptyList(),
    val showSearchError: Boolean = false
)

sealed class UIEvent {
    data class QueryChanged(val query: String) : UIEvent()
    data class Search(val query: String) : UIEvent()
}