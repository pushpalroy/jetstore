package com.example.play.ui.details.reviews

import androidx.compose.animation.core.TransitionState
import androidx.compose.animation.transition
import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons.Outlined
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview
import com.example.play.anim.AppRatingBarState
import com.example.play.anim.getAppRatingBarTransitionDefinition
import com.example.play.theme.PlayTheme
import com.example.play.theme.Typography
import com.example.play.ui.components.PlaySurface
import com.example.play.ui.components.progressindicator.AnimatedProgressIndicator

@Composable
fun RatingsAndReviews() {
  Column(
      modifier = Modifier.padding(top = 4.dp, start = 24.dp, end = 16.dp, bottom = 8.dp)
  ) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
      Text(
          text = "Ratings and reviews",
          style = TextStyle(
              fontWeight = FontWeight.Medium,
              fontSize = 16.sp,
              letterSpacing = 0.15.sp
          ),
          color = PlayTheme.colors.textSecondaryDark,
          modifier = Modifier.weight(1f)
      )
      IconButton(
          onClick = {},
          modifier = Modifier.align(Alignment.Top)
      ) {
        Icon(
            asset = Outlined.ArrowForward,
            tint = PlayTheme.colors.iconTint
        )
      }
    }
    Row(modifier = Modifier.padding(top = 16.dp)) {
      Text(
          text = "4.7",
          style = TextStyle(
              fontWeight = FontWeight.SemiBold,
              fontSize = 50.sp,
              letterSpacing = 0.15.sp
          ),
          color = PlayTheme.colors.textPrimary,
          modifier = Modifier.align(Alignment.Top)
      )
      Column(modifier = Modifier.padding(start = 24.dp)) {
        Row {
          Text(
              text = "5",
              style = Typography.caption,
              color = PlayTheme.colors.textSecondaryDark,
              modifier = Modifier.align(Alignment.CenterVertically)
          )
          AnimatedProgressIndicator(
              state = getAppRatingBarState(progress = 0.8f, 4000),
              color = PlayTheme.colors.accent
          )
        }
        Spacer(modifier = Modifier.height(3.dp))
        Row {
          Text(
              text = "4",
              style = Typography.caption,
              color = PlayTheme.colors.textSecondaryDark,
              modifier = Modifier.align(Alignment.CenterVertically)
          )
          AnimatedProgressIndicator(
              state = getAppRatingBarState(progress = 0.5f),
              color = PlayTheme.colors.accent
          )
        }
        Spacer(modifier = Modifier.height(3.dp))
        Row {
          Text(
              text = "3",
              style = Typography.caption,
              color = PlayTheme.colors.textSecondaryDark,
              modifier = Modifier.align(Alignment.CenterVertically)
          )
          AnimatedProgressIndicator(
              state = getAppRatingBarState(progress = 0.3f, 4000),
              color = PlayTheme.colors.accent
          )
        }
        Spacer(modifier = Modifier.height(3.dp))
        Row {
          Text(
              text = "2",
              style = Typography.caption,
              color = PlayTheme.colors.textSecondaryDark,
              modifier = Modifier.align(Alignment.CenterVertically)
          )
          AnimatedProgressIndicator(
              state = getAppRatingBarState(progress = 0.1f),
              color = PlayTheme.colors.accent
          )
        }
        Spacer(modifier = Modifier.height(3.dp))
        Row {
          Text(
              text = "1",
              style = Typography.caption,
              color = PlayTheme.colors.textSecondaryDark,
              modifier = Modifier.align(Alignment.CenterVertically)
          )
          AnimatedProgressIndicator(
              state = getAppRatingBarState(progress = 0.2f, 4000),
              color = PlayTheme.colors.accent
          )
        }
      }
    }
  }
}

@Composable
fun getAppRatingBarState(
  progress: Float,
  durationMillis: Int = 3000
): TransitionState {
  val appRatingTransitionDef =
    getAppRatingBarTransitionDefinition(progress, durationMillis)
  return transition(
      definition = appRatingTransitionDef,
      initState = AppRatingBarState.START,
      toState = AppRatingBarState.END
  )
}

@Preview("Ratings and Reviews")
@Composable
private fun ReviewsPreview() {
  PlayTheme {
    PlaySurface {
      RatingsAndReviews()
    }
  }
}

@Preview("Ratings and Reviews Dark")
@Composable
private fun ReviewsDarkPreview() {
  PlayTheme(darkTheme = true) {
    PlaySurface {
      RatingsAndReviews()
    }
  }
}