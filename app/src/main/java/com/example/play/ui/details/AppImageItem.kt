package com.example.play.ui.details

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Stack
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
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.example.play.ui.components.PlayCard
import com.example.play.ui.components.RoundedCornerAppImage
import com.example.play.theme.PlayTheme

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
          .preferredSize(
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
      Stack(
          modifier = Modifier
              .preferredHeight(180.dp)
              .fillMaxWidth()
      ) {
        RoundedCornerAppImage(
            imageUrl = imageUrl,
            modifier = Modifier
                .preferredWidth(300.dp)
                .preferredHeight(180.dp)
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