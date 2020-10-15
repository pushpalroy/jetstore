package com.example.play.ui.movies.movielist

import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.preferredHeight
import androidx.compose.foundation.layout.preferredSize
import androidx.compose.foundation.layout.preferredWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign.Center
import androidx.compose.ui.text.style.TextOverflow.Ellipsis
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview
import com.example.play.R.drawable
import com.example.play.data.AppRepo
import com.example.play.data.Movie
import com.example.play.theme.PlayTheme
import com.example.play.ui.components.PlayCard
import com.example.play.ui.components.PlaySurface
import com.example.play.ui.components.RoundedCornerAppImage

@Composable
fun MovieItem(
  movie: Movie,
  modifier: Modifier = Modifier
) {
  PlayCard(
      elevation = 0.dp,
      shape = MaterialTheme.shapes.large,
      modifier = modifier
          .preferredSize(
              width = 120.dp,
              height = 240.dp
          )
          .padding(bottom = 8.dp)
  ) {
    Column(
        modifier = Modifier
            .clickable(onClick = {})
            .fillMaxSize()
    ) {
      Box(
          modifier = Modifier
              .preferredHeight(180.dp)
              .fillMaxWidth()
      ) {
        RoundedCornerAppImage(
            imageUrl = movie.imageUrl,
            modifier = Modifier
                .preferredWidth(120.dp)
                .preferredHeight(180.dp)
                .align(Alignment.TopStart)
                .padding(8.dp),
            cornerPercent = 10
        )
      }
      Spacer(modifier = Modifier.preferredHeight(3.dp))
      Text(
          text = movie.name,
          style = TextStyle(
              fontWeight = FontWeight.Normal,
              fontSize = 12.sp,
              letterSpacing = 0.15.sp
          ),
          color = PlayTheme.colors.textPrimary,
          maxLines = 1,
          overflow = Ellipsis,
          modifier = Modifier.padding(start = 8.dp)
      )
      Spacer(modifier = Modifier.preferredHeight(4.dp))
      Row(modifier = Modifier.padding(start = 8.dp)) {
        Text(
            text = movie.ratings,
            style = TextStyle(
                fontWeight = FontWeight.Light,
                fontSize = 12.sp,
                letterSpacing = 0.15.sp
            ),
            color = PlayTheme.colors.textSecondaryDark,
            maxLines = 1,
            overflow = Ellipsis
        )
        Icon(
            asset = vectorResource(id = drawable.ic_star_solid),
            tint = PlayTheme.colors.iconTint,
            modifier = Modifier
                .padding(start = 2.dp, end = 8.dp)
                .preferredWidth(8.dp)
                .preferredHeight(8.dp)
                .align(Alignment.CenterVertically)
        )
        Text(
            text = movie.price,
            style = TextStyle(
                fontWeight = FontWeight.Light,
                fontSize = 12.sp,
                letterSpacing = 0.15.sp
            ),
            color = PlayTheme.colors.textSecondaryDark,
            maxLines = 1,
            overflow = Ellipsis
        )
      }
    }
  }
}

@Composable
fun TopSellingMovieItem(
  movie: Movie,
  modifier: Modifier = Modifier
) {
  PlaySurface(
      modifier = modifier
          .fillMaxWidth()
          .clickable(onClick = { })
  ) {
    Row(modifier = Modifier.padding(start = 16.dp, end = 8.dp, top = 4.dp, bottom = 4.dp)) {
      Text(
          text = movie.id.toString(),
          style = TextStyle(
              fontWeight = FontWeight.Normal,
              fontSize = 14.sp
          ),
          textAlign = Center,
          color = PlayTheme.colors.textSecondary,
          modifier = Modifier
              .align(Alignment.CenterVertically)
              .preferredWidth(30.dp)
              .padding(end = 8.dp)
      )
      Box(
          modifier = Modifier
              .preferredHeight(90.dp)
              .preferredWidth(65.dp)
      ) {
        RoundedCornerAppImage(
            imageUrl = movie.imageUrl,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopStart)
                .padding(8.dp),
            cornerPercent = 5
        )
      }
      Column(
          modifier = Modifier.padding(top = 4.dp, start = 8.dp)
              .align(Alignment.Top)
      ) {
        Text(
            text = movie.name,
            style = TextStyle(
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                letterSpacing = 0.15.sp
            ),
            color = PlayTheme.colors.textPrimary,
            maxLines = 1,
            modifier = Modifier.padding(bottom = 3.dp),
            overflow = Ellipsis
        )
        Text(
            text = movie.category,
            style = TextStyle(
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp,
                letterSpacing = 0.15.sp
            ),
            color = PlayTheme.colors.textSecondary,
            maxLines = 1,
            overflow = Ellipsis,
            modifier = Modifier.padding(bottom = 2.dp)
        )
        Row(modifier = Modifier.padding(bottom = 2.dp)) {
          Text(
              text = movie.ratings,
              style = TextStyle(
                  fontWeight = FontWeight.Light,
                  fontSize = 12.sp,
                  letterSpacing = 0.15.sp
              ),
              color = PlayTheme.colors.textSecondaryDark,
              maxLines = 1,
              overflow = Ellipsis
          )
          Icon(
              asset = vectorResource(id = drawable.ic_star_solid),
              tint = PlayTheme.colors.iconTint,
              modifier = Modifier
                  .padding(start = 2.dp, end = 8.dp)
                  .preferredWidth(8.dp)
                  .preferredHeight(8.dp)
                  .align(Alignment.CenterVertically)
          )
        }
        Text(
            text = movie.price,
            style = TextStyle(
                fontWeight = FontWeight.Light,
                fontSize = 12.sp,
                letterSpacing = 0.15.sp
            ),
            color = PlayTheme.colors.textSecondaryDark,
            maxLines = 1,
            overflow = Ellipsis,
            modifier = Modifier.padding(bottom = 2.dp),
        )
      }
    }
  }
}

@Preview("Movie Item")
@Composable
fun PlayMovieItemPreview() {
  PlayTheme {
    val movie = AppRepo.getMovie(2L)
    MovieItem(
        movie = movie
    )
  }
}

@Preview("Top Selling Movie Item")
@Composable
fun TopSellingMovieItemPreview() {
  PlayTheme {
    val movie = AppRepo.getMovie(1L)
    TopSellingMovieItem(
        movie = movie
    )
  }
}