package com.example.play.ui.details.screenshots

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.play.data.AppRepo
import com.example.play.theme.PlayTheme
import com.example.play.ui.details.AppImageItem

@Composable
fun Screenshots(
  imageUrlList: List<String> = AppRepo.getScreenshots(),
  onImageClick: () -> Unit = {},
  modifier: Modifier = Modifier
) {
  //val scrollState = rememberScrollState(0)
  Spacer(modifier = Modifier.width(16.dp))
  LazyRow(
    modifier = modifier
  ) {
    items(imageUrlList) { imageUrlItem ->
      ScreenshotListItem(imageUrlItem, onImageClick)
    }
  }
}

@Composable
fun ScreenshotListItem(
  imageUrl: String,
  onImageClick: () -> Unit
) {
  AppImageItem(imageUrl, onImageClick)
  Spacer(modifier = Modifier.width(8.dp))
}

@Preview("App Images")
@Composable
private fun AppImagesPreview() {
  PlayTheme {
    Screenshots(
      imageUrlList = listOf("", "", "", "")
    )
  }
}

@Preview("App Images Dark")
@Composable
private fun AppImagesDarkPreview() {
  PlayTheme(darkTheme = true) {
    Screenshots(
      imageUrlList = listOf("", "", "", "")
    )
  }
}