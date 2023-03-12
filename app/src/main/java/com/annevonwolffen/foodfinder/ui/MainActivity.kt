package com.annevonwolffen.foodfinder.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.annevonwolffen.foodfinder.ui.theme.FoodFinderTheme

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
        // Scaffold(
        //     topBar = { SearchTopBar() },
        //     bottomBar = {
        //
        //     }
        // ) { padding ->
        //     SearchContent(Modifier.padding(padding))
        // }
    }
}

