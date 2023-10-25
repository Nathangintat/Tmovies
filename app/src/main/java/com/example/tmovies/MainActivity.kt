package com.example.tmovies

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tmovies.presentation.movie_detail.MovieDetailScreen
import com.example.tmovies.presentation.movie_list.MovieListScreen
import com.example.tmovies.ui.theme.TmoviesTheme
import com.example.tmovies.util.Route
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TmoviesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Route.MovieRoute.route
                    ) {
                        composable(
                            route = Route.MovieRoute.route
                        ) {
                            MovieListScreen(
                                onClick = {
                                          navController.navigate(Route.MovieDetailRoute.route + "/$it")
                                },
                                navController = navController
                            )
                        }
                        composable(
                            route = Route.MovieDetailRoute.route + "/{movieId}"
                        ) {
                            MovieDetailScreen(onBack = {
                                                       navController.navigate(Route.MovieRoute.route + "/$it")
                            },
                                navController = navController
                            )
                        }
                    }
                }
            }
        }
    }
}
