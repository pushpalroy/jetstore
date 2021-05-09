package com.example.play.ui.components.progressindicator

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.progressSemantics
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.play.anim.getAppRatingBarState
import com.example.play.theme.PlayTheme

/**
 * A custom animated determinate linear progress indicator that represents progress by drawing a rounded rectangle.
 *
 * @param state The transition state of progress of this progress indicator, where 0.0 represents no progress and 1.0
 * represents full progress. Values outside of this range are coerced into the range.
 * @param color The color of the progress indicator.
 * @param backgroundColor The color of the background behind the indicator, visible when the
 * progress has not reached that area of the overall indicator yet.
 */
@Composable
fun AnimatedProgressIndicator(
  modifier: Modifier = Modifier.padding(start = 8.dp, end = 8.dp),
  progress: Float,
  durationMillis: Int = 3000,
  color: Color = MaterialTheme.colors.primary,
  strokeWidth: Dp = 9.dp,
  backgroundColor: Color = PlayTheme.colors.progressIndicatorBg,
  showProgress: MutableState<Boolean>
) {
  val state = getAppRatingBarState(
      progress = progress, durationMillis = durationMillis, showProgress = showProgress.value
  )
  Canvas(
      modifier
          .progressSemantics(state.value)
          .size(280.dp, strokeWidth)
  ) {
    drawRoundRect(
        color = backgroundColor,
        cornerRadius = CornerRadius(15f, 15f),
        size = Size(size.width, size.height)
    )
    drawRoundRect(
        color = color, cornerRadius = CornerRadius(15f, 15f),
        size = Size(state.value * size.width, size.height)
    )
  }
}

@Composable
fun StarRatings(
  modifier: Modifier = Modifier,
  ratings: Double = 3.5,
  sizeInDp: Dp = 15.dp
) {
  Box(modifier = modifier) {
    Row {
      for (i in 1..5) {
        Star(sizeInDp)
      }
    }
    Row {
      for (i in 1..ratings.toInt()) {
        StarFilled(sizeInDp)
      }
    }
  }
}

@Composable
fun Star(sizeInDp: Dp) {
  Icon(
      imageVector = Icons.Filled.Star, tint = PlayTheme.colors.progressIndicatorBg,
      modifier = Modifier
          .height(sizeInDp)
          .width(sizeInDp),
      contentDescription = null
  )
}

@Composable
fun StarFilled(sizeInDp: Dp) {
  Icon(
      imageVector = Icons.Filled.Star, tint = PlayTheme.colors.accent,
      modifier = Modifier
          .height(sizeInDp)
          .width(sizeInDp),
      contentDescription = null
  )
}