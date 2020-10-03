package com.example.play.ui.components.progressindicator

import androidx.compose.animation.core.TransitionState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Icon
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.preferredSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.progressSemantics
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Radius
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.play.anim.appRatingBar
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
    state: TransitionState,
    color: Color = MaterialTheme.colors.primary,
    modifier: Modifier = Modifier.padding(start = 8.dp, end = 8.dp),
    strokeWidth: Dp = 9.dp,
    backgroundColor: Color = PlayTheme.colors.progressIndicatorBg
) {
  Canvas(
      modifier
          .progressSemantics(state[appRatingBar])
          .preferredSize(280.dp, strokeWidth)
  ) {
    drawRoundRect(
        color = backgroundColor, radius = Radius(15f, 15f), size = Size(size.width, size.height)
    )
    drawRoundRect(
        color = color, radius = Radius(15f, 15f),
        size = Size(state[appRatingBar] * size.width, size.height)
    )
  }
}

@Composable
fun StarRatings(
    ratings: Double = 3.5,
    modifier: Modifier = Modifier,
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
      asset = Icons.Filled.Star, tint = PlayTheme.colors.progressIndicatorBg,
      modifier = Modifier
          .height(sizeInDp)
          .width(sizeInDp)
  )
}

@Composable
fun StarFilled(sizeInDp: Dp) {
  Icon(
      asset = Icons.Filled.Star, tint = PlayTheme.colors.accent,
      modifier = Modifier
          .height(sizeInDp)
          .width(sizeInDp)
  )
}