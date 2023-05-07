package com.annevonwolffen.foodfinder.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.annevonwolffen.foodfinder.ui.profile.ProfileScreen
import com.annevonwolffen.foodfinder.ui.recipes.RecipesScreen
import com.annevonwolffen.foodfinder.ui.theme.FoodFinderTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodFinderApp()
        }
    }
}

@Composable
fun FoodFinderApp() {
    FoodFinderTheme {
        val navController = rememberNavController()
        Scaffold { paddingValues ->
            FoodFinderNavHost(
                navController = navController,
                modifier = Modifier.padding(paddingValues)
            )
        }
    }
}

@Composable
fun FoodFinderNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = MainDestination.route,
        modifier = modifier
    ) {
        composable(route = MainDestination.route) {
            MainScreen(
                onStartButtonClick = {
                    navController.navigate(it.route)
                }
            )
        }
        composable(route = StartDestinations.Recipes.route) {
            RecipesScreen()
        }
        composable(route = StartDestinations.Profile.route) {
            ProfileScreen()
        }
    }
}

@Composable
fun MainScreen(
    onStartButtonClick: (StartDestinations) -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(
                space = 32.dp,
                alignment = Alignment.CenterHorizontally
            )
        ) {
            StartDestinations.values().forEach {
                Button(onClick = {
                    onStartButtonClick(it)
                }) {
                    Text(text = it.name)
                }
            }
        }
    }
}

