package com.example.play.ui.details

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
  appId: Long?,
  upPress: () -> Unit
) {
  val app = remember(appId) { AppRepo.getApp(appId) }
  val isInstalling = remember { mutableStateOf(false) }

  PlaySurface(
    modifier = Modifier.fillMaxSize()
  ) {
    AppBarLayout(upPress = upPress)
    LazyColumn(
      horizontalAlignment = Alignment.CenterHorizontally,
      modifier = Modifier
        .fillMaxSize()
        .padding(top = 56.dp)
    ) {
      item {
        app?.let { safeApp ->
          Header(app = safeApp, showProgress = isInstalling)
          Stats(app = safeApp)
        }
        InstallButtonLayout(isInstalling = isInstalling)
        Screenshots()
        About()
        RatingsAndReviews()
      }
    }
  }
}

@Preview("App Detail")
@Composable
private fun AppDetailPreview() {
  PlayTheme {
    AppDetails(
      appId = 1L,
      upPress = {}
    )
  }
}

//@Preview("App Detail Dark")
//@Composable
//private fun AppDetailDarkPreview() {
//  PlayTheme(darkTheme = true) {
//    AppDetails(
//      appId = 1L,
//      upPress = {}
//    )
//  }