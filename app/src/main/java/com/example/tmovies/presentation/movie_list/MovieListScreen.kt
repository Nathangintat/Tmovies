package com.example.tmovies.presentation.movie_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.tmovies.presentation.movie_list.component.MovieList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieListScreen(
    onClick: (Int) -> Unit,
    viewModel: MovieListViewModel = hiltViewModel(),
    navController: NavController
) {
    val movies = viewModel.movies.collectAsLazyPagingItems()

    Scaffold (
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Tmovies"
                    )
                },
                actions = {
                    TextButton(
                        onClick = {}
                    ) {
                        Text(
                            text = "Login/Register"
                        )
                    }
                }
            )
        }
    ) {padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentAlignment = Alignment.Center
        ) {
            if (movies.loadState.append == LoadState.Loading) {
                CircularProgressIndicator()
            }

            MovieList(
                items = movies,
                onClick = {onClick ->
                    onClick(onClick)
                }
            )
        }
    }
}