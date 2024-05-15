package com.example.teamsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.teamsapp.teamslist.SharedViewModel
import com.example.teamsapp.ui.screens.TeamDetailsScreen
import com.example.teamsapp.ui.screens.TeamListScreen
import com.example.teamsapp.ui.theme.TeamsAppTheme

@OptIn(ExperimentalSharedTransitionApi::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TeamsAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.primary
                ) {
                    val navController = rememberNavController()
                    val sharedViewModel = SharedViewModel()
                    SharedTransitionLayout {
                        NavHost(
                            navController = navController,
                            startDestination = "list"
                        ) {
                            composable("list") {
                                TeamListScreen(
                                    onItemClick = {
                                        navController.navigate("detail")
                                    },
                                    animatedVisibilityScope = this,
                                    sharedViewModel = sharedViewModel,
                                )
                            }
                            composable(
                                route = "detail",

                            ) {

                                TeamDetailsScreen(
                                    navController =navController,
                                    animatedVisibilityScope = this,
                                    sharedViewModel = sharedViewModel
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

