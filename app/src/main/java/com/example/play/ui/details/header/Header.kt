package com.example.play.ui.details.header

import android.annotation.SuppressLint
import androidx.compose.animation.core.Transition
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.play.data.App
import com.example.play.data.AppRepo
import com.example.play.theme.PlayTheme
import com.example.play.theme.Typography
import com.example.play.ui.components.PlaySurface
import com.example.play.ui.components.RoundedCornerAppImage

private enum class AppIconState {
  IDLE,
  INSTALLING
}

@SuppressLint("Range")
@Composable
fun Header(
  app: App,
  showProgress: Boolean
) {
  val toState by remember { mutableStateOf(AppIconState.IDLE) }
  val transition: Transition<AppIconState> = updateTransition(targetState = toState)

  val appIconSize by transition.animateDp { state ->
    when (state) {
      AppIconState.IDLE -> 1.dp
      AppIconState.INSTALLING -> 0.dp
    }
  }

  Row(modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 8.dp)) {
    Box(
        modifier = Modifier
            .height(100.dp)
            .width(100.dp)
    ) {
      if (showProgress) {
        CircularProgressIndicator(
            color = PlayTheme.colors.accent,
            strokeWidth = 2.dp,
            modifier = Modifier.size(100.dp)
        )
      }
      RoundedCornerAppImage(
          imageUrl = app.imageUrl,
          modifier = Modifier
              .width(appIconSize)
              .height(appIconSize)
              .align(Alignment.Center)
              .padding(8.dp),
          cornerPercent = 20
      )
    }
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
      Text(
          text = app.name,
          style = TextStyle(
              fontWeight = FontWeight.SemiBold,
              fontSize = 24.sp,
              letterSpacing = 0.15.sp
          ),
          color = PlayTheme.colors.textPrimary,
          modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 8.dp)
      )
      Text(
          text = app.org,
          maxLines = 1,
          style = Typography.subtitle2,
          fontWeight = FontWeight.W600,
          color = PlayTheme.colors.accent,
          modifier = Modifier.padding(start = 16.dp, top = 4.dp)
      )
      Text(
          text = app.info,
          maxLines = 1,
          style = Typography.caption,
          color = PlayTheme.colors.iconTint,
          modifier = Modifier.padding(start = 16.dp)
      )
    }
  }
}

@Preview("Header")
@Composable
private fun HeaderPreview() {
  PlayTheme {
    PlaySurface {
      Header(
          app = AppRepo.getApp(1L),
          showProgress = true
      )
    }
  }
}

@Preview("Header Dark")
@Composable
private fun HeaderDarkPreview() {
  PlayTheme(darkTheme = true) {
    PlaySurface {
      Header(
          app = AppRepo.getApp(1L),
          showProgress = true
      )
    }
  }
}