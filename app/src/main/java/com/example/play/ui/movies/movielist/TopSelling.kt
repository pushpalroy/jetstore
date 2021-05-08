package com.example.play.ui.movies.movielist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.example.play.data.AppRepo
import com.example.play.data.Movie
import com.example.play.theme.PlayTheme

@Composable
fun TopSellingLayout(
  moviesCollection: List<Movie>,
  modifier: Modifier = Modifier
) {
  Column(modifier = modifier) {
    TopSellingMoviesList(
        movies = moviesCollection
    )
  }
}

@Composable
private fun TopSellingMoviesList(
  movies: List<Movie>,
  modifier: Modifier = Modifier
) {
  LazyColumn(modifier = modifier.padding(top = 8.dp)) {
    movies.forEach { movie ->
      TopSellingMovieItem(movie)
    }
  }
}

@Preview("Top Selling preview")
@Composable
fun TopSellingPreview() {
  PlayTheme {
    TopSellingLayout(moviesCollection = AppRepo.getTopSellingMovies())
  }
}

@Preview("Top Selling dark preview")
@Composable
fun TopSellingDarkPreview() {
  PlayTheme(darkTheme = true) {
    TopSellingLayout(moviesCollection = AppRepo.getTopSellingMovies())
  }
}