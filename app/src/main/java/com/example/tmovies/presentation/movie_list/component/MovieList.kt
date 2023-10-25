package com.example.tmovies.presentation.movie_list.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import com.example.tmovies.domain.model.Movie

@Composable
fun MovieList(
    modifier: Modifier = Modifier,
    items: LazyPagingItems<Movie>,
    onClick: (Int) -> Unit
) {
    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxSize(),
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(
            1.dp
        ),
        verticalArrangement = Arrangement.spacedBy(2.dp),
        horizontalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        items(
            count = items.itemCount
        ) { index ->
            items[index]?.let { movie ->
                MovieListItem(
                    modifier = Modifier.clickable { onClick(movie.id) },
                    movie = movie
                )
            }
        }
    }
}