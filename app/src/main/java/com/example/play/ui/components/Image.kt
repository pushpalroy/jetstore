package com.example.play.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.example.play.theme.PlayTheme

@Composable
fun CircularAppImage(
  imageUrl: String,
  modifier: Modifier = Modifier,
  elevation: Dp = 0.dp
) {
  PlaySurface(
      color = Color.LightGray,
      elevation = elevation,
      shape = CircleShape,
      modifier = modifier
  ) {
    CoilImage(
        data = imageUrl,
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize(),
        contentDescription = null
    )
  }
}

@Composable
fun CircularLocalImage(
  resId: Int,
  modifier: Modifier = Modifier,
  elevation: Dp = 0.dp
) {
  PlaySurface(
      color = Color.LightGray,
      elevation = elevation,
      shape = CircleShape,
      modifier = modifier
  ) {
    Image(
        painterResource(resId),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
    )
  }
}

@Composable
fun RoundedCornerAppImage(
  imageUrl: String,
  modifier: Modifier = Modifier,
  cornerPercent: Int,
  elevation: Dp = 0.dp
) {
  PlaySurface(
      color = Color.LightGray,
      elevation = elevation,
      shape = RoundedCornerShape(cornerPercent),
      modifier = modifier
  ) {
    CoilImage(
        data = imageUrl,
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize(),
        contentDescription = null
    )
  }
}

@Preview("Circular App Image")
@Composable
fun CircularAppImagePreview() {
  PlayTheme(darkTheme = true) {
    CircularAppImage(
        imageUrl = "",
        modifier = Modifier
            .size(120.dp),
        elevation = 10.dp
    )
  }
}

@Preview("Rounded Corner App Image")
@Composable
fun RoundedCornerAppImagePreview() {
  PlayTheme(darkTheme = true) {
    RoundedCornerAppImage(
        imageUrl = "",
        modifier = Modifier
            .size(120.dp),
        cornerPercent = 5,
        elevation = 10.dp
    )
  }
}