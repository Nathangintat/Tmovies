package com.example.tmovies.util

sealed class Route(val route: String) {
    object MovieRoute: Route("movie_list")
    object MovieDetailRoute: Route("movie_detail_screen")
}