package com.example.play.ui.details.header

import android.annotation.SuppressLint
import androidx.compose.animation.transition
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.preferredHeight
import androidx.compose.foundation.layout.preferredSize
import androidx.compose.foundation.layout.preferredWidth
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview
import com.example.play.anim.AppIconState
import com.example.play.anim.AppIconState.INSTALLING
import com.example.play.anim.appIconSize
import com.example.play.anim.getAppIconTransitionDefinition
import com.example.play.data.App
import com.example.play.data.AppRepo
import com.example.play.theme.PlayTheme
import com.example.play.theme.Typography
import com.example.play.ui.components.PlaySurface
import com.example.play.ui.components.RoundedCornerAppImage

@SuppressLint("Range")
@Composable
fun Header(
  app: App,
  showProgress: Boolean,
  appIconSizeState: AppIconState
) {
  val appIconTransitionDef = getAppIconTransitionDefinition()
  val toState = if (appIconSizeState == INSTALLING) {
    AppIconState.IDLE
  } else {
    INSTALLING
  }
  val state = transition(
      definition = appIconTransitionDef,
      initState = appIconSizeState,
      toState = toState
  )

  Row(modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 8.dp)) {
    Box(
        modifier = Modifier
            .preferredHeight(100.dp)
            .preferredWidth(100.dp)
    ) {
      if (showProgress) {
        CircularProgressIndicator(
            color = PlayTheme.colors.accent,
            strokeWidth = 2.dp,
            modifier = Modifier.preferredSize(100.dp)
        )
      }
      RoundedCornerAppImage(
          imageUrl = app.imageUrl,
          modifier = Modifier
              .preferredWidth(state[appIconSize])
              .preferredHeight(state[appIconSize])
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
          showProgress = true,
          appIconSizeState = INSTALLING
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
          showProgress = true,
          appIconSizeState = INSTALLING
      )
    }
  }
}