package com.example.tmovies.presentation.movie_list.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.tmovies.domain.model.Movie
import com.example.tmovies.ui.theme.TmoviesTheme

@Composable
fun MovieListItem(
    modifier: Modifier = Modifier,
    movie: Movie,

) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {
            AsyncImage(
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color.Gray),
                model = "https://image.tmdb.org/t/p/original/" + movie.posterPath,
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            Text(
                text = movie.title,
                style = MaterialTheme.typography.bodyLarge
            )

            Text(
                text = "Rating: ${movie.voteAverage}",
                style = MaterialTheme.typography.bodyMedium
            )
            
            Text(
                text = "(${movie.voteCount})",
                style = MaterialTheme.typography.bodySmall
            )
        }
        if (movie.adult) {
            Text(
                modifier = Modifier
                    .padding(10.dp)
                    .clip(CircleShape)
                    .background(Color.Red)
                    .size(32.dp)
                    .align(Alignment.TopEnd)
                    .wrapContentHeight(Alignment.CenterVertically),
                text = "18+",
                style = MaterialTheme.typography.labelMedium,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview
@Composable
fun MovieListPreview() {
    TmoviesTheme {
        MovieListItem(movie = Movie(
            title = "ABCD",
            popularity = 0.0,
            posterPath = "",
            id = 0,
            voteAverage = 0.0,
            voteCount = 0,
            adult = true
        ))
    }
}