package com.annevonwolffen.foodfinder.ui.recipes

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun RecipesScreen() {
    val pagerState = rememberPagerState()
    Scaffold(
        bottomBar = { Tabs(pagerState = pagerState) }
    ) { padding ->
        RecipesScreenPager(pagerState = pagerState, modifier = Modifier.padding(padding))
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Tabs(
    pagerState: PagerState,
    modifier: Modifier = Modifier
) {
    val scope = rememberCoroutineScope()
    TabRow(selectedTabIndex = pagerState.currentPage, modifier = modifier) {
        RecipesScreens.values().forEach { screen ->
            Tab(
                selected = pagerState.currentPage == screen.ordinal,
                text = { Text(text = screen.name) },
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(screen.ordinal)
                    }
                }
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RecipesScreenPager(
    pagerState: PagerState,
    modifier: Modifier = Modifier
) {
    HorizontalPager(
        pageCount = RecipesScreens.values().size,
        state = pagerState,
        modifier = modifier
    ) { page ->
        RecipesScreens.values()[page].searchContentScreen()
    }
}