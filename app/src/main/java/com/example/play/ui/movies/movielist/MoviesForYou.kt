package com.example.play.ui.movies.movielist

import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.preferredHeight
import androidx.compose.foundation.layout.preferredWidth
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.foundation.lazy.LazyRowFor
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview
import com.example.play.data.AppRepo
import com.example.play.data.Movie
import com.example.play.data.MovieCollection
import com.example.play.theme.PlayTheme
import com.example.play.utils.navigationBarsPadding

@Composable
fun MoviesForYouLayout(
  data: List<MovieCollection>,
  modifier: Modifier = Modifier
) {
  Spacer(
      modifier = Modifier
          .preferredHeight(4.dp)
  )
  LazyColumnFor(items = data, modifier = modifier) { moviesCollection ->
    key(moviesCollection.id) {
      MoviesForYou(
          moviesCollection = moviesCollection
      )
    }
  }
  Spacer(
      modifier = Modifier
          .navigationBarsPadding(left = false, right = false)
          .preferredHeight(8.dp)
  )
}

@Composable
fun MoviesForYou(
  moviesCollection: MovieCollection,
  modifier: Modifier = Modifier
) {
  Column(modifier = modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(start = 24.dp)
    ) {
      Text(
          text = moviesCollection.name,
          style = TextStyle(
              fontWeight = FontWeight.Medium,
              fontSize = 16.sp,
              letterSpacing = 0.15.sp
          ),
          color = PlayTheme.colors.textPrimary,
          maxLines = 1,
          overflow = TextOverflow.Ellipsis,
          modifier = Modifier.weight(1f)
      )
      IconButton(
          onClick = {},
          modifier = Modifier.align(Alignment.CenterVertically)
      ) {
        Icon(
            asset = Icons.Outlined.ArrowForward,
            tint = PlayTheme.colors.iconTint
        )
      }
    }
    MoviesList(moviesCollection.movies)
  }
}

@Composable
private fun MoviesList(
  movies: List<Movie>,
  modifier: Modifier = Modifier.padding(start = 16.dp)
) {
  LazyRowFor(items = movies, modifier = modifier) { movie ->
    MovieItem(movie)
    Spacer(modifier = Modifier.preferredWidth(1.dp))
  }
}

@Preview("Movies For You list preview")
@Composable
fun MoviesForYouListPreview() {
  PlayTheme {
    MoviesForYouLayout(data = AppRepo.getMovies())
  }
}

@Preview("Movies For You list dark preview")
@Composable
fun MoviesForYouListDarkPreview() {
  PlayTheme(darkTheme = true) {
    MoviesForYouLayout(data = AppRepo.getMovies())
  }
}