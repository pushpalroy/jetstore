package com.example.play.ui.details.screenshots

import androidx.compose.foundation.ScrollableRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.preferredWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.example.play.data.AppRepo
import com.example.play.theme.PlayTheme
import com.example.play.ui.details.AppImageItem

@Composable
fun Screenshots(
  imageUrlList: List<String> = AppRepo.getScreenshots(),
  onImageClick: () -> Unit = {},
  modifier: Modifier = Modifier
) {
  val scroll = rememberScrollState(0f)
  ScrollableRow(
      scrollState = scroll,
      modifier = modifier
  ) {
    Spacer(modifier = Modifier.preferredWidth(16.dp))
    imageUrlList.forEach { imageUrl ->
      AppImageItem(imageUrl, onImageClick)
      Spacer(modifier = Modifier.preferredWidth(8.dp))
    }
  }
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