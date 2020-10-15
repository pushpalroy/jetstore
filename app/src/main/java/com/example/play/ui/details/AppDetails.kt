package com.example.play.ui.details

import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.example.play.anim.AppIconState.INSTALLING
import com.example.play.data.AppRepo
import com.example.play.theme.PlayTheme
import com.example.play.ui.components.AppBarLayout
import com.example.play.ui.components.PlaySurface
import com.example.play.ui.details.about.About
import com.example.play.ui.details.header.Header
import com.example.play.ui.details.installbutton.animated.InstallButtonLayout
import com.example.play.ui.details.reviews.RatingsAndReviews
import com.example.play.ui.details.screenshots.Screenshots
import com.example.play.ui.details.stats.Stats

@Composable
fun AppDetails(
  appId: Long,
  backPress: () -> Unit
) {
  val app = remember(appId) { AppRepo.getApp(appId) }
  val (appIconSizeState, updateAppIconSize) = remember { mutableStateOf(INSTALLING) }
  val (progressState, updateProgress) = remember { mutableStateOf(false) }

  PlaySurface(
      modifier = Modifier.fillMaxSize()
  ) {
    AppBarLayout(backPress)
    ScrollableColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
            .padding(top = 56.dp)
    ) {
      Header(app, progressState, appIconSizeState)
      Stats(app)
      InstallButtonLayout(updateProgress, updateAppIconSize)
      Screenshots()
      About()
      RatingsAndReviews()
    }
  }
}

@Preview("App Detail")
@Composable
private fun AppDetailPreview() {
  PlayTheme {
    AppDetails(
        appId = 1L,
        backPress = { }
    )
  }
}

@Preview("App Detail Dark")
@Composable
private fun AppDetailDarkPreview() {
  PlayTheme(darkTheme = true) {
    AppDetails(
        appId = 1L,
        backPress = { }
    )
  }
}