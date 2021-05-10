package com.example.play.ui.details.stats

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Download
import androidx.compose.material.icons.outlined.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow.Ellipsis
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.play.data.App
import com.example.play.data.AppRepo
import com.example.play.theme.PlayTheme
import com.example.play.ui.components.PlaySurface

@Composable
fun Stats(app: App) {
  Row(
    modifier = Modifier
      .padding(top = 8.dp, start = 16.dp, end = 16.dp)
  ) {
    Column(modifier = Modifier.padding(end = 12.dp)) {
      Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
        Text(
          text = app.ratings,
          maxLines = 1,
          overflow = Ellipsis,
          style = MaterialTheme.typography.subtitle1,
          fontWeight = FontWeight.Bold,
          color = PlayTheme.colors.textSecondaryDark
        )
        Icon(
          imageVector = Icons.Outlined.Star,
          tint = PlayTheme.colors.textSecondaryDark,
          modifier = Modifier
            .padding(end = 8.dp)
            .width(14.dp)
            .height(14.dp)
            .align(Alignment.CenterVertically),
          contentDescription = null
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
        .width(1.dp)
        .height(24.dp)
        .fillMaxHeight()
        .align(Alignment.CenterVertically)
        .background(color = PlayTheme.colors.uiBorder)
    )
    Column(modifier = Modifier.padding(start = 12.dp, end = 12.dp)) {
      Icon(
        imageVector = Icons.Outlined.Download,
        tint = PlayTheme.colors.textSecondaryDark,
        modifier = Modifier
          .padding(end = 8.dp)
          .width(21.dp)
          .height(21.dp)
          .align(Alignment.CenterHorizontally),
        contentDescription = null
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
        .width(1.dp)
        .height(24.dp)
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
        .width(1.dp)
        .height(24.dp)
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
      AppRepo.getApp(1L)?.let { safeApp ->
        Stats(safeApp)
      }
    }
  }
}

@Preview("Stats Dark")
@Composable
private fun StatsDarkPreview() {
  PlayTheme(darkTheme = true) {
    PlaySurface {
      AppRepo.getApp(1L)?.let { safeApp ->
        Stats(safeApp)
      }
    }
  }
}