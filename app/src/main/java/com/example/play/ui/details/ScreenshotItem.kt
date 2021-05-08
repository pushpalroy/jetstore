package com.example.play.ui.details

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.play.theme.PlayTheme
import com.example.play.ui.components.PlayCard
import com.example.play.ui.components.RoundedCornerAppImage

@Composable
fun AppImageItem(
  imageUrl: String,
  onImageClick: () -> Unit,
  modifier: Modifier = Modifier
) {
  PlayCard(
      elevation = 0.dp,
      shape = MaterialTheme.shapes.large,
      modifier = modifier
          .size(
              width = 300.dp,
              height = 180.dp
          )
          .padding(bottom = 8.dp)
  ) {
    Column(
        modifier = Modifier
            .clickable(onClick = onImageClick)
            .fillMaxSize()
    ) {
      Box(
          modifier = Modifier
              .height(180.dp)
              .fillMaxWidth()
      ) {
        RoundedCornerAppImage(
            imageUrl = imageUrl,
            modifier = Modifier
                .width(300.dp)
                .height(180.dp)
                .align(Alignment.TopStart)
                .padding(8.dp),
            cornerPercent = 5
        )
      }
    }
  }
}

@Preview("App Image Item")
@Composable
fun PlayFeaturedAppItemPreview() {
  PlayTheme {
    AppImageItem(
        imageUrl = "",
        onImageClick = { }
    )
  }
}