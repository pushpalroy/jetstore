package com.example.play.ui.details.stats

import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope.align
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.preferredHeight
import androidx.compose.foundation.layout.preferredWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.example.play.R.drawable
import com.example.play.data.models.App
import com.example.play.data.AppRepo
import com.example.play.theme.PlayTheme
import com.example.play.ui.components.PlaySurface

@Composable
fun Stats(app: App) {
  Row(
      modifier = Modifier
          .padding(top = 8.dp, start = 16.dp, end = 16.dp)
          .align(Alignment.CenterHorizontally)
  ) {
    Column(modifier = Modifier.padding(end = 12.dp)) {
      Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
        Text(
            text = app.ratings,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.subtitle1,
            fontWeight = FontWeight.Bold,
            color = PlayTheme.colors.textSecondaryDark
        )
        Icon(
            asset = vectorResource(id = drawable.ic_star_solid),
            tint = PlayTheme.colors.textSecondaryDark,
            modifier = Modifier
                .padding(end = 8.dp)
                .preferredWidth(14.dp)
                .preferredHeight(14.dp)
                .align(Alignment.CenterVertically)
        )
      }
      Text(
          text = "636K Reviews",
          maxLines = 1,
          style = MaterialTheme.typography.caption,
          color = PlayTheme.colors.textSecondary
      )
    }
    Spacer(
        modifier = Modifier
            .preferredWidth(1.dp)
            .preferredHeight(24.dp)
            .fillMaxHeight()
            .align(Alignment.CenterVertically)
            .background(color = PlayTheme.colors.uiBorder)
    )
    Column(modifier = Modifier.padding(start = 12.dp, end = 12.dp)) {
      Icon(
          asset = vectorResource(id = drawable.ic_download),
          tint = PlayTheme.colors.textSecondaryDark,
          modifier = Modifier
              .padding(end = 8.dp)
              .preferredWidth(21.dp)
              .preferredHeight(21.dp)
              .align(Alignment.CenterHorizontally)
      )
      Text(
          text = "9.9 MB",
          maxLines = 1,
          style = MaterialTheme.typography.caption,
          color = PlayTheme.colors.textSecondary,
          modifier = Modifier.align(Alignment.CenterHorizontally)
      )
    }
    Spacer(
        modifier = Modifier
            .preferredWidth(1.dp)
            .preferredHeight(24.dp)
            .fillMaxHeight()
            .align(Alignment.CenterVertically)
            .background(color = PlayTheme.colors.uiBorder)
    )
    Column(modifier = Modifier.padding(start = 12.dp, end = 12.dp)) {
      Text(
          text = "3+",
          maxLines = 1,
          style = MaterialTheme.typography.subtitle1,
          fontWeight = FontWeight.Bold,
          color = PlayTheme.colors.textSecondaryDark,
          modifier = Modifier.align(Alignment.CenterHorizontally)
      )
      Text(
          text = "Rated For 3+",
          maxLines = 1,
          style = MaterialTheme.typography.caption,
          color = PlayTheme.colors.textSecondary,
          modifier = Modifier.align(Alignment.CenterHorizontally)
      )
    }
    Spacer(
        modifier = Modifier
            .preferredWidth(1.dp)
            .preferredHeight(24.dp)
            .fillMaxHeight()
            .align(Alignment.CenterVertically)
            .background(color = PlayTheme.colors.uiBorder)
    )
    Column(modifier = Modifier.padding(start = 12.dp, end = 12.dp)) {
      Text(
          text = "10M+",
          maxLines = 1,
          style = MaterialTheme.typography.subtitle1,
          fontWeight = FontWeight.Bold,
          color = PlayTheme.colors.textSecondaryDark,
          modifier = Modifier.align(Alignment.CenterHorizontally)
      )
      Text(
          text = "Downloads",
          maxLines = 1,
          style = MaterialTheme.typography.caption,
          color = PlayTheme.colors.textSecondary,
          modifier = Modifier.align(Alignment.CenterHorizontally)
      )
    }
  }
}

@Preview("Stats")
@Composable
private fun StatsPreview() {
  PlayTheme {
    PlaySurface {
      Stats(
          AppRepo.getApp(1L)
      )
    }
  }
}

@Preview("Stats Dark")
@Composable
private fun StatsDarkPreview() {
  PlayTheme(darkTheme = true) {
    PlaySurface {
      Stats(
          AppRepo.getApp(1L)
      )
    }
  }
}