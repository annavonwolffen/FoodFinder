package com.annevonwolffen.foodfinder.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.annevonwolffen.foodfinder.ui.theme.FoodFinderTheme
import kotlinx.coroutines.launch

@ExperimentalFoundationApi
@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodFinderApp()
        }
    }
}

@ExperimentalMaterial3Api
@ExperimentalFoundationApi
@Composable
fun FoodFinderApp() {
    FoodFinderTheme {
        val pagerState = rememberPagerState()
        val scope = rememberCoroutineScope()
        Scaffold(
            topBar = { SearchTopBar() },
            bottomBar = {
                TabRow(selectedTabIndex = pagerState.currentPage) {
                    Tab(
                        selected = pagerState.currentPage == 0,
                        text = { Text(text = "Recipes") },
                        onClick = {
                            scope.launch {
                                pagerState.animateScrollToPage(0)
                            }
                        }
                    )
                    Tab(
                        selected = pagerState.currentPage == 0,
                        text = { Text(text = "Food") },
                        onClick = {
                            scope.launch {
                                pagerState.animateScrollToPage(0)
                            }
                        }
                    )
                }
            }
        ) { padding ->
            HorizontalPager(
                pageCount = 2,
                state = pagerState,
                modifier = Modifier.padding(padding)
            ) { page ->
                when (page) {
                    0 -> SearchRecipesScreen()
                    1 -> SearchFoodScreen()
                }

            }
        }
    }
}

@Composable
fun SearchRecipesScreen() {
    Box(
        Modifier.fillMaxSize()
    ) {
        Text(text = "Recipes")
    }
}

@Composable
fun SearchFoodScreen() {
    Box(
        Modifier.fillMaxSize()
    ) {
        Text(text = "Food")
    }
}

