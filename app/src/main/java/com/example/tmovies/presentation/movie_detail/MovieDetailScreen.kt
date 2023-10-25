package com.example.tmovies.presentation.movie_detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieDetailScreen(
    viewModel: MovieDetailViewModel = hiltViewModel(),
    onBack: () -> Unit,
    navController: NavController
) {
    val state = viewModel.state.value
    val movie = state.movie

    Scaffold(
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
            ) {
                IconButton(
                    modifier = Modifier.align(Alignment.CenterStart),
                    onClick = {
                        onBack()
                    }
                ) {
                    Icon(
                        imageVector = Icons.Rounded.ArrowBack,
                        contentDescription = "Back"
                    )
                }

                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = "Movie Detail"
                )
            }
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentPadding = PaddingValues(24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                AsyncImage(
                    modifier = Modifier,
                    model = "https://image.tmdb.org/t/p/original/" + state.movie?.posterPath,
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
            }

            item {
                movie?.let {
                    Text(
                        text = it.title,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
            // dengan menggunakan let akan menjadi kosong sama sekali tanpa tulisan null atau apapun

            item {
                Text(
                    text = "genre:",
                    style = MaterialTheme.typography.bodySmall
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    state.movie?.genres?.forEach {
                        Text(
                            text = it.name,
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }
            }



            item {
                Row (
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        text = "Rating: ${state.movie?.voteAverage}",
                        style = MaterialTheme.typography.bodySmall
                    )

                    Text(
                        text = " ${state.movie?.voteCount} ",
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }

            item {
                Text(
                    text = "Despcription: ${state.movie?.overview}",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}
